package com.javalearning.spouts;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanrq on 15-11-9.
 */
public class WordReader extends BaseRichSpout {
    private SpoutOutputCollector spoutOutputCollector;
    private TopologyContext topologyContext;
    private boolean completed = false;

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("line"));
    }

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.topologyContext = topologyContext;
        this.spoutOutputCollector = spoutOutputCollector;
    }

    @Override
    public void nextTuple() {
        if (completed) {
            return;
        }
        File file = new File("./WordFile.txt");
        try {
            List<String> strings = Files.readLines(file, Charsets.UTF_8);
            for (String string : strings) {
                this.spoutOutputCollector.emit(new Values(string), string);
            }
            completed = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
