package com.hsartori.challenges.interviews;

import java.util.*;

import static java.lang.Math.floor;

/**
 * Company: Amazon
 * <br><br>
 * Description:
 * <ul>
 *     <li>Each channel needs to have at one packet sent;</li>
 *     <li>Each channel has a quality, that is defined by the median of the packets sent on it;</li>
 *     <li>The sum of the quality of all channels must be MAXIMIZED;</li>
 *     <li>Return the maximized qualities sum;</li>
 *     <li>If quality is a decimal number, round up to the long value;</li>
 * </ul>
 * Input:
 * <ul>
 *     <li>Number of channels</li>
 *     <li>Array of integers representing one packet value</li>
 * </ul>
 */
public class MedianPackets {

    public double quality(final List<Long> values) {
        final int size = values.size();
        final int mid = ((int) floor(values.size() / 2.0));
        if (size % 2 == 1) {
            return values.get(mid);
        } else {
            return (values.get(mid) + values.get(mid - 1)) / 2.0;
        }
    }

    public double calc(final long channels, final long ...packets) {

        // Sort packets in descending order
        final PriorityQueue<Long> queue = new PriorityQueue<>((a, b) -> -a.compareTo(b));
        for (long packet : packets) {
            queue.add(packet);
        }

        // Init each channel with head of queue
        final Map<Long, List<Long>> map = new HashMap<>();
        for (long i = 0; i < channels; i++) {
            final List<Long> array = new LinkedList<>();
            array.add(queue.poll());
            map.put(i, array);
        }

        // Init all channels if head of queue
        while (!queue.isEmpty()) {
            final long packet = queue.poll();

            // Find best channel to add value, that will increase the median the most.
            // TIP: The best channel will be ALWAYS the one with the lower packet if the
            //      packets array is sorted in decreasing order, and you assign the
            //      greatest packet to the first channel
            //      (in this case, it will always be the last one)
            List<Long> bestChannel = map.get(channels - 1);
            bestChannel.add(packet);

        }

        // Calc response
        return map.values().stream().mapToDouble(this::quality).sum();

    }

}
