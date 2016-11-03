package excecoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BusinessException extends RuntimeException {

    private Collection<String> errors;

    public BusinessException(String error) {
        this(errorToList(error));
    }

    private static Collection<String> errorToList(String error) {
        return Collections.singletonList(error);

    }

    public BusinessException(Collection<String> errors) {
        this.errors = Collections.unmodifiableList(new ArrayList<>(errors));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        boolean first = true;
        for (String error : this.errors) {
            if (!first)
                sb.append(", ");
            else
                first = false;
            sb.append(error);
        }
        return sb.toString();
    }
}
