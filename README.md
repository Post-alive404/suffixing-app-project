# Suffixing App

Java Applications is basing only on functional requirements.


## Suffixing App Specification

1. The application takes a one obligatory argument - the path to a config file.
2. Config file format is `properties` (you may benefit from using `java.util.Properties` class) and contains three fields:
    - `mode` - renaming mode. Valid values (*case-insensitive*):
      - `copy` - keep the source file
      - `move` - remove the source file 
    - `suffix` - the suffix, that mut be added to the file name (*before* file extension).
    - `files` - a list of files for suffixing. File paths are separated with column`:`.
3. The application must use a Logger (from `java.util.logging`) to log messages:
    - if mode from config is not recognized, log `Mode is not recognized: <mod_input_value>` at SEVERE level and stop the execution.\
      Example: `Mode is not recognized: copi`
    - if suffix is not set, log `No suffix is configured` at SEVERE level and stop the execution.
    - if files are not specified, log `No files are configured to be copied/moved` at WARNING level and stop the execution.
    - if one of the specified files does not exist, log `No such file: <file-path>` at SEVERE level, but do not stop the processing of other files.
    - When moving a file, log `<source-file> -> <destination-file>` at INFO level.\
      Example: `src/test/resources/file.txt -> src/test/resources/file-suffix.txt`      
    - When moving a file, log `<source-file> => <destination-file>` at INFO level.\
