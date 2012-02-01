/************************************************
 * This file was generated by ....
 ************************************************/

package prototype;


/**
 * Exception raised when a required field is null.
 */
public class NullityException extends Exception {

    /**
     * Required for serialization.
     */
    static final long serialVersionUID = 200710190250666L;


    /**
     * Create a new NullityException.
     * @param className The name of the class containing the null value.
     * @param field The name of the field containing the null value.
     */
    public NullityException(final String className, final String field) {
        super("The field " + field + " of the class " + className
               + " should not contain a null value.");
    }
}
