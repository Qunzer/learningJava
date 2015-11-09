package com.javalearning;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import com.javalearning.bolts.WordCounter;
import com.javalearning.bolts.WordNormalizer;
import com.javalearning.spouts.WordReader;

/**
 * Hello world!
 */
public class TopologyMain {
    public static void main(String[] args) throws InterruptedException {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("word-reader", new WordReader());
        builder.setBolt("word-normalizer", new WordNormalizer()).shuffleGrouping("word-reader");
        builder.setBolt("word-counter", new WordCounter(), 2).fieldsGrouping("word-normalizer", new Fields("word"));

        Config conf = new Config();
        conf.setMaxTaskParallelism(3);
        conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 3);
        conf.setDebug(false);

        //Topology run
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("storm-wordcount", conf, builder.createTopology());
        Thread.sleep(30000);
        cluster.shutdown();
    }
}
