/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package enterprise.web_security_annotation_client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class WebSecurityAnnotationClient {

    static String host = System.getProperty("http.host","localhost");
    static String portS = System.getProperty("http.port","8080");
    static int port = new Integer(portS).intValue();
    static final String url = "/httpomission/omissionservlet";
    static final String auth = "Authorization: Basic amF2YWVlNnVzZXI6YWJjMTIz\n";

    public static void main(String args[])throws Exception {
        //goGet();
        goPost();
    }

    /**
     * Connect to host:port and issue GET with given auth info.
     *
     */
    private static void goGet()
            throws Exception {
        Socket s = new Socket(host, port);
        OutputStream os = s.getOutputStream();

        os.write(("GET "+url+"\n").getBytes());
        os.write(auth.getBytes());
        os.write("\n".getBytes());

        InputStream is = s.getInputStream();
        BufferedReader bis = new BufferedReader(new InputStreamReader(is));
        String line = null;

        while ((line = bis.readLine()) != null) {
           System.out.println(line);
        }

        s.close();
        
    }
    /**
     * Connect to host:port and issue GET with given auth info.
     *
     */
    private static void goPost()
            throws Exception {
        Socket s = new Socket(host, port);
        OutputStream os = s.getOutputStream();

        os.write(("POST "+url+"\n").getBytes());
        os.write(auth.getBytes());
        os.write("\n".getBytes());

        InputStream is = s.getInputStream();
        BufferedReader bis = new BufferedReader(new InputStreamReader(is));
        String line = null;

        while ((line = bis.readLine()) != null) {
           System.out.println(line);
        }

        s.close();
        
    }
}