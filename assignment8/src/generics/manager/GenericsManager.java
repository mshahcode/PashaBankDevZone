package generics.manager;

import java.util.Collection;

public class GenericsManager {

    public <T> boolean containsVariable(Collection<T> collection, T variable){
        return collection.contains(variable);
    }
}
