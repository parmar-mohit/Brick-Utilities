package com.brick.utilities.file;

import com.brick.utilities.BrickMap;
import com.brick.utilities.exception.InvalidData;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
    Description: Reads Config Data from file and provides method to access them
 */
public class YamlFileReader extends FileReader {

    public YamlFileReader(String fileName) {
        super(fileName);
    }

    /*
        Description: Returns BrickMap of YamlData From File
     */
    @Override
    public BrickMap getMap() throws FileNotFoundException, InvalidData {
        Yaml yamlFile = new Yaml();

        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(this.fileName)) {
            if (in == null) {
                throw new FileNotFoundException("Cannot Find File : "+ this.fileName);
            }

            return new BrickMap(yamlFile.load(in));
        } catch (IOException e) {
            throw new FileNotFoundException("Cannot Find File : "+ this.fileName);
        }catch(YAMLException e){ // When File is not Valid Yaml
            throw new InvalidData(this.fileName);
        }
    }
}
