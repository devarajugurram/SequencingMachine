### SEQUENCING PROBLEM
*"Sequencing Problem"* play a crucial role in many areas of operating research.Here is one of the specific way in which sequencing Problem are used in operating research.

> Applications Of Sequencing Problem
```
1. manufacturing plant,
2. aircraft waiting for landing and clearance, 
3. maintenance scheduling in a factory,
4. computer centre,
5. customers in a bank.
```
> Steps to Implement Sequencing Problem in Operating Research:

```
Import JAVA Module Files

Take input from keyboard i.e., Machines and Jobs

Initalize Two Dimensional Array arr[machine][Jobs]

Take input m number of Jobs for n number of machines

Make n > 2 number of machines into 2 machines
    
    ->for i:=0 to Jobs:
    
          ->for j := 1 to Jobs-1:
    
                  arr[0][i] :+= arr[j][i];
              
          ->for j:=2 to Jobs:
          
                  arr[1][i] :+= arr[j][i]; 

if n < 2 throw an Exception()

From two machine convert into single Dimensional Array with minimum values corresponding to its columns 

for i := 0 to Jobs:

     if(min == arr[1][j]) assign value[0][i]
     
     else assign value[1][i]
     
Sort the Array 

Search the Elements of value array in arr and make a copy of positions

if the minimum element found in machine A add at starting of Array else at Ending of Array

Create a Dummy 2 machine Array supl

z := 0, w := machine-1

sequenc[] an array declration

forEach(x : sortedArray):
    
    for i:=0 to machine:
    
        if x == dup[0][i]
        
            sequence[z++] = i+1
        
            dup[0][i] = dup[1][i] = Integer.MAX_VALUE
        
            break
    
    else if x == dupl[1][i]
    
            sequence[w--] = i+1
            
            dup[0][i] = dup[1][i] = Integer.MAX_VALUE
            
            break
          
 print sequence
```

This Method help us to solve the problems related to Sequencing Problem. And makes problem simple and useful for Productive machine allocation. 
>Time Complexity O(n^2)

>Space Complexity O(n^2)
