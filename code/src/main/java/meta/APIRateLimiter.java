package meta;

import java.awt.print.Pageable;
import java.util.*;

public class APIRateLimiter {

    static Map<String, Queue<Long>> holder = new HashMap();
    static int TIME_LIMIT = 100;
    static int MAX_HITS = 5;

    public static void main(String[] args) {
        List<Input> inputs = new ArrayList();
        inputs.add(new Input("A", 1000));
        inputs.add(new Input("A", 1002));
        inputs.add(new Input("A", 1020));
        inputs.add(new Input("A", 1030));
        inputs.add(new Input("A", 1050));
        inputs.add(new Input("A", 1051));
        inputs.add(new Input("A", 1099));
        inputs.add(new Input("A", 1100));
        inputs.add(new Input("A", 1101));

        for (Input input : inputs) {
            hitAPI(input.clientId, input.timeOfHit);
        }
    }

    public static void hitAPI(String clientId, long timeOfHit) {
        boolean result = isAllowed(clientId, timeOfHit);
        if (result)
            System.out.println("hit @ " + timeOfHit + " ms");
        else
            System.out.println("blocked @ " + timeOfHit + " ms");
    }

    public static boolean isAllowed(String clientId, long timeOfHit) {
        boolean result = false;
        if (holder.containsKey(clientId)) {
            Queue<Long> timings = holder.get(clientId);
            while (!timings.isEmpty() && timeOfHit - timings.peek() >= TIME_LIMIT) {
                timings.poll();
            }
            if (timings.size() < MAX_HITS) {
                timings.add(timeOfHit);
                holder.put(clientId, timings);
                result = true;
            }
        } else {
            // client hitting first time, simply put it in holder
            Queue<Long> timings = new LinkedList();
            timings.add(timeOfHit);
            holder.put(clientId, timings);
            result = true;
        }
        return result;
    }
}

class Input {
    public String clientId;
    public long timeOfHit;

    public Input(String clientId, long timeOfHit) {
        this.clientId = clientId;
        this.timeOfHit = timeOfHit;
    }
}
