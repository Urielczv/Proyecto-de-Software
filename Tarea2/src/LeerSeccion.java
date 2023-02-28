import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LeerSeccion {
    void LeerYComparar (){
        try {
            //abrimos el archivo principal.xml, para poder sacar la info.
            File documentoXml = new File("Principal.xml");
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Builder = dbfactory.newDocumentBuilder();
            Document document = Builder.parse(documentoXml);
            document.getDocumentElement().normalize();
            NodeList llamadas = document.getElementsByTagName("llamada");

            //abrimos el archivo xml que es el catalogo de secciones
            File archivoXml = new File("Secciones.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document documento = builder.parse(archivoXml);
            documento.getDocumentElement().normalize();
            NodeList secciones = documento.getElementsByTagName("seccion");
            Node seccion = secciones.item(0);
            Element elemento = (Element) seccion;
            
            //declaramos una variable string para gurdar el dato del catalogo de seleccion 
            String SEccion = null;

            //declaramos una variable string, se usara para obtener los valores con las variables
            String zona = null;

            //recorremos el archivo principal
            for(int i = 0; i < llamadas.getLength(); i++){
                Node llamada = llamadas.item(i);

                //comparamos su los datos del archivos son elementos
                if(llamada.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) llamada;

                    //imprimimos cada uno de los datos del archivo
                    System.out.println(element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println(element.getElementsByTagName("numero").item(0).getTextContent());
                    System.out.println(element.getElementsByTagName("tipo").item(0).getTextContent());

                    //gurdamos el dato de la etiqueta SECCION en la variable SEccion
                    SEccion = element.getElementsByTagName("SECCION").item(0).getTextContent();
                    //esta linea imprime el valor de la seccion dependiendo que contenga.
                    System.out.println(elemento.getElementsByTagName(SEccion).item(0).getTextContent());

                    //gurdamos el valor de la etiqueta zona en la variable zona
                    zona = element.getElementsByTagName("zona").item(0).getTextContent();
                    //mandamos a llamar a la funcion variable y le pasamos el parametro zona
                    variables(zona);
                }
            }
        } catch (Exception e ) {
            
        }
    }



    void variables (String zona){

        //declaramos nuestras variables con las que vamos a comparar la variable zona
        String norte = "norte";
        String sur = "Sur";
        String este = "Este";
        String oeste = "Oeste";

        //en el switch comparamos la variable zona y dependiendo del valor que tenga va a imprimir un caso u otro
        switch (zona) {
            case ("n"):
                System.out.println(norte);
                System.out.println();
                break;
            case ("s"):
                System.out.println(sur);
                System.out.println();
                break;
            case ("e"):
                System.out.println(este);
                System.out.println();
                break;
            case("o"):
            System.out.println(oeste);
            System.out.println();
            break;
            default:
                break;
        }
    }
}