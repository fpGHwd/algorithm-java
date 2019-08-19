/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 5/3/19
 * @Time: 5:44 PM
 */

package network;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    @Test
    public void testInetAddress() throws UnknownHostException {

        String r = "cathy.autove.dev";
        InetAddress ia = InetAddress.getByName(r);
    }
}
