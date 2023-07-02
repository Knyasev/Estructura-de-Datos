/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import static java.lang.System.in;

/**
 *
 * @author wilson7578
 */
public class Conexion {
    
   private XStream xstream;
   public static String Url = "data/";
    public XStream conectar (){
     xstream = new XStream( new JettisonMappedXmlDriver());
           xstream.setMode(XStream.NO_REFERENCES);
           xstream.addPermission(AnyTypePermission.ANY);

           return  xstream;
   }
    
    public XStream getXstream(){
        if (xstream==null ) {
            conectar();
            
        }
        return xstream;
    }

    public void setXstream(XStream xstream) {
        this.xstream = xstream;
    }
    
    
}
