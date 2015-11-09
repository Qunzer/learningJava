package com.javalearning.bolts;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Map;
import java.util.Set;

/**
 * Created by yuanrq on 15-11-9.
 */
public class WordCounter extends BaseRichBolt {

    private Multiset<String> counters;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.counters = HashMultiset.create();
    }

    @Override
    public void execute(Tuple input) {
        String word = input.getString(0);
        counters.add(word);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    @Override
    public void cleanup() {
        Set<String> strings = counters.elementSet();
        for (String string : strings) {
            System.out.println(string + ":" + counters.count(string));
        }
    }
}
