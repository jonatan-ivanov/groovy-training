import org.apache.commons.io.IOUtils

@Grab(group='commons-io', module='commons-io', version='2.4')
public class TestClass {
    public static void main (String[] args) {
        println IOUtils.toByteArray("abcd")
    }
}
