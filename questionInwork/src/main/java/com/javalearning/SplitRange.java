package com.javalearning;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.math.IntMath;

import java.math.RoundingMode;
import java.util.List;

/**
 * Created by renqun.yuan on 2015/11/3.
 */
public class SplitRange {
    public static List<Range<Integer>> splitRange(int minId, int maxId, int rangeNo) {
        List<Range<Integer>> rangeList = Lists.newArrayList();
        if (minId == 0 && maxId == 0) {
            Range<Integer> range = Range.closed(minId, maxId);
            rangeList.add(range);
            return rangeList;
        }

//        int rangeSize = (maxId - minId)/rangeNo + 1;

        int rangeSize = IntMath.divide(maxId - minId + 1, rangeNo, RoundingMode.CEILING);

        int startId = minId;
        int endId = minId + rangeSize - 1;

        while (endId <= maxId) {

            Range<Integer> range = Range.closed(startId, endId);
            rangeList.add(range);
            startId = startId + rangeSize;
            endId = endId + rangeSize;
            if (startId <= maxId && endId >= maxId) {
                endId = maxId;
                Range<Integer> lastRange = Range.closed(startId, endId);
                rangeList.add(lastRange);
                break;
            }
        }
        return rangeList;
    }

    public static void main(String[] args) {
        System.out.println(splitRange(5, 8, 9));
//        System.out.println(splitRange(13, 100009, 4));
//        System.out.println(splitRange(9, 100009, 2));
    }
}
