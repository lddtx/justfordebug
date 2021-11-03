package on.enums;

import java.util.EnumMap;
import java.util.Map;

import static on.enums.AlarmPoints.*;

interface Command {void action();}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, () -> System.out.println("Kitchen fire!"));
        em.put(BATHROOM, () -> System.out.println("Bathroom alert!"));

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + ": " );
            e.getValue().action();
        }

        em.get(UTILITY).action();
    }
}
