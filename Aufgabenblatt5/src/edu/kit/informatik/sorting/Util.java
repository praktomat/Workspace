
package edu.kit.informatik.sorting;

/**
 * Contains methods that operate on or return sorted lists or are otherwise used by list implementations.
 * 
 * @author  Tobias Bachert
 * @version 1.00, 2016/12/16
 */
final class Util {
    
    private Util() {
        ////
    }
    
    /**
     * Checks that the specified object reference is not {@code null}.
     * 
     * @param  <T> type parameter
     * @param  reference the reference
     * @return the reference
     * @throws NullPointerException if the reference is {@code null}
     * @see    java.util.Objects#requireNonNull(Object)
     */
    public static <T> T requireNonNull(
            final T reference) {
        ////
        if (reference == null)
            throw new NullPointerException();
        return reference;
    }
    
    /**
     * Returns a string representation of the specified list.
     * 
     * @param  list the list
     * @return the string representation
     */
    public static String toString(
            final SortedAppendList<?> list) {
        ////
        return toString(list, ", ", "[", "]");
    }
    
    /**
     * Returns a string representation of the specified list.
     * 
     * <p>The returned string will have the format
     * <blockquote><pre>
     * [prefix]([first]([delimiter][element])*)?[suffix]</pre>
     * </blockquote>
     * 
     * @param  list the list
     * @param  delimiter the delimiter to use
     * @param  prefix the prefix to use
     * @param  suffix the suffix to use
     * @return the string representation
     */
    public static String toString(
            final SortedAppendList<?> list,
            final String delimiter,
            final String prefix,
            final String suffix) {
        ////
        final StringBuilder sb = new StringBuilder().append(prefix);
        list.forEach(value -> sb.append(value).append(delimiter));
        if (sb.length() != prefix.length())
            sb.setLength(sb.length() - delimiter.length());
        return sb.append(suffix).toString();
    }
}
