package HomeWork.HomeWork11.DI;

import java.io.*;

public class Factory {
    public static <T> T injectDependency(Class parent, String field, String file) {
        String packageDir = "HomeWork.HomeWork11.";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (br != null) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] injParams = line.split("\\.|->");

                    String className = injParams[0].trim();
                    String fieldName = injParams[1].trim();

                    if ((Class.forName(packageDir + className) == parent) && (field.equals(fieldName))) {
                        String injectable = injParams[2].trim();
                        T returnValue = (T) Class.forName(packageDir + injectable).newInstance();
                        System.out.println(returnValue.getClass());
                        return returnValue;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

