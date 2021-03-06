**_Inversion, eigenvalues of matrices, using Java._**

Some of Apache's matrix utility classes are used to find the inverse and the eigenvalues of (somewhat fictitious) matrix-like structures.  Instances of matrices are created, so that multiple matrices are able to exist simultaneously.

It's pretended that the most fundamental properties of these matrix-like structures are matrix shape, matrix dimension, and element size and element numerical accuracy.  These features are specified in interface StructureInterfaceA.  This is in turn inherited from by StructureInterfaceB.

Unless stated otherwise, these structures behave exactly like normal matrices.

A 2 x 2 matrix example is provided.  It's written in a way that allows for experimenting with as many different techniques as possible, but also in a way that should make adding classes and methods relatively easy.

One of the techniques demonstrates the creation and use of a generic double array.  This demanded the implementation of reflection.


The following two linux terminal commands...

1. _javac -classpath .:/home/USRNAME/Downloads/commons-math3-3.6.1/commons-math3-3.6.1.jar:/home/USRNAME/Downloads/commons-lang3-3.4/commons-lang3-3.4.jar gitjavamatrix/Main.java_

2. _java -classpath .:/home/USRNAME/Downloads/commons-math3-3.6.1/commons-math3-3.6.1.jar:/home/USRNAME/Downloads/commons-lang3-3.4/commons-lang3-3.4.jar gitjavamatrix/Main_

... will perform 'compile and run' if a) the Apache 'jars' are in 'Downloads', b) the _.java_ files are in directory called gitjavamatrix, and c) you are one directory level higher than that. 
