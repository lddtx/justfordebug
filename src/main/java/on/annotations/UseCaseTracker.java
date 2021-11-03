package on.annotations;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UseCaseTracker {
    public static void trackUseCase(List<Integer> useCases, Class<?> c) {
        for (Method m : c.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case " + uc.id() + "\n" + uc.desc());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }
        useCases.forEach(i -> System.out.println("missing use case " + i));
    }

    public static void main(String[] args) {
        List<Integer> useCases = IntStream.range(47, 51).boxed().collect(Collectors.toList());
        trackUseCase(useCases, PasswordUtils.class);
    }
}
