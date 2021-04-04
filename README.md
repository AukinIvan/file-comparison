# File comparison

### Test task

Implement a Java-based application to compare two text files.

Input:

1. Original text file
2. Modified text file

Output:

1. Text that describes a difference between the Modified and the Original file.

### Level 2

1. Application requirements:
    * Use third-party library for document comparison.
2. Input:
    * The Modified file can have added/deleted lines in comparison to the Original file.
3. Output:
    * List of added/deleted lines (in any format). Compare by lines, not by words. A modified line may be considered as
      deleted+added.

>Notice: you may use any output format that will show the difference between the files.


### User manual

```
java -jar file-comparison.jar [original file] [modified file]
```

> Example: 
> 
> `java -jar file-comparison.jar original.txt modified.txt`
