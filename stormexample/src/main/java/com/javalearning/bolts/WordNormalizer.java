package com.javalearning.bolts;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanrq on 15-11-9.
 */
public class WordNormalizer extends BaseRichBolt {
    private OutputCollector outputCollector;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.outputCollector = collector;
    }

    @Override
    public void execute(Tuple input) {
        String line = input.getString(0);
        List<String> words = Splitter.on(" ").omitEmptyStrings().splitToList(line);
        for (String word : words) {
            String temp = word.toLowerCase();
            outputCollector.emit(new Values(temp));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }
}
