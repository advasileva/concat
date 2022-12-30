# Concat

Educational project on the discipline Software Design

The description of the task is in `Task.pdf`

## Architecture

There are 9 entities (classes and interfaces) in the project. Their relationship is shown in the diagram:

![diagram](https://github.com/advasileva/concat/blob/develop/img/classes.png)

The functionality is described in the corresponding JavaDocs, but ideologically the decomposition is as follows:

+ `Main` and `Concat` provide high-level program logic;
+ The package `graph` is responsible for generalized work with graphs: cycle detection and topological sorting of vertices;
+ The package `source` processes input files and extracts dependencies. Also there is the `Content` interface for working with the contents of files.

## Quick start

To test the work, you can use the example in `example/`

The program requests absolute paths, so the input will look like this:
```
Enter source directory (abs path):
<absolute path to the project>\concat\example\in
Enter target file (abs path):
<absolute path to the project>\concat\example\out\result
```
