JavaTypeAutoConverter utility
=====
This project implements utility class for automatic cast objects to destination class
JavaTypeAutoConverter detect type of input object and select convertation way to destination class.
____
Utility support many types transformations:
 - Number to Boolean
 - String to Date with detect convert mask
 - String to any Number(Long, BigDecimal,  Float and i.e.)
 - any Number to any Number
 - array to array of destination type
 - Collection to array of destination type
____
Example of using JavaTypeAutoConverter :
```Java
 Float f =  TypeAutoConverter.convert("42.42", Float.class);
 BigDecimal n = TypeAutoConverter.convert("42.42", BigDecimal.class);
 Boolean b = TypeAutoConverter.convert(Float.valueOf(1), Boolean.class);
 Integer[] arr = TypeAutoConverter.convertToArray(new String[]{"1", "2", "3"}, Integer.class);
```
