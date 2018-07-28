#THOUGHTWORKS INTERVIEW CODE ASSIGNMENT MERCHANT"S GUIDE TO GALAXY ROMAN NUMBERS
---------------------------------------------------------------------------------
#PROBLEM
-------
Merchant's Guide to the Galaxy
 
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
 
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
 
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.
 
Roman numerals are based on seven symbols:
 
Symbol

Value

I

1

V

5

X

10

L

50

C

100

D

500

M

1,000

 
Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.
 
The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
Only one small-value symbol may be subtracted from any large-value symbol.
A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
(Source: Wikipedia ( [17]http://en.wikipedia.org/wiki/Roman_numerals)
 
Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.
 
You are expected to handle invalid queries appropriately.
 
Test input:
glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
 
Test Output:
pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about

#PRINCIPLES
-------------
TDD approach has been followed.
No object is directly instantiated by client but accessed with a factory.
Every Service/Class is single responsibility and modular.

#DISCLAIMER
-------------
Not all edge cases considered.
Validations are a bit weak due to time constraints.

#SOLUTION
---------
The solution mainly has four parts the Input Interpreter, Output interpreter, Data Store and Roman Number Evaluator.

##Input Interpreter
-------------------
The Input Interpreter implementation is created from the InterpreterFactory. The InputInterpreter has three processor to Accept three types of input.

###AliasRuleProcessor
---------------------
This interprets and processes all the instructions pertaining to creating aliases for the roman Numbers e.g. "pish is X". It also supports multiple aliases for each roman literal. Finally stores the aliases in the data store.

###CreditCoinRuleProcessor
--------------------------
This interprets the value of each credit coin currency e.g. Gold, Silver or Iron. It inerprets instructions like "glob prok Gold is 57800 Credits". It evaluates the romans and the aliases, calculates the credit coin value and stores it in the Data Store.

###QueryProcessor
-----------------
This just interprets the queries like "how many Credits is glob prok Silver ?" or "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?" and stores it in datastore. There is no validation of query done here.

##DataStore
------------
All the states are managed here by means of static class level variables. Which means all the states are maintained in Java Perm Gen with the loaded classes. They will be accessible within the lifecycle of the program.

###AliasCache
-------------
Stores all the aliases for the roman literals.

###CreditCoinCache
------------------
Sores all the Credit Coin Values like Gold=14450d and Silver=17d etc.

###QueryCache
-------------
Stores list of queries to be processes by OutputInterpreter.

###RomanNumberCache
-------------------
Stores Roman Literals.

##OutputInterpreter
---------------------
This processes the query cache and evaluates the queries. There are two types of queries Credit Coin queries "how many Credits is glob prok Silver ?" and simple roman value queries "how much is pish tegj glob glob ?"

###CreditValueOutputProcessor
-----------------------------
###RomanValueOutputProcessor
----------------------------

##RomanEvaluator
-----------------
This has a validation section and a interpretation section. this is used to convert the roman number to arabic. In case of invalid parse it throws an exception.

###Validators
-------------
Three types of validations considered.

####AllowableRomanLiterals
--------------------------
Only I, V, X, L, C, D, M are allowed.

####UniqueLiterals
-----------------
V,L and D can be used only once.

####ContiguousLiterals
---------------------
I,X,C and M can be used continuously max for 3 times ie. MMM or CCC

###UnitInterpreter
-------------------
This follows a standard pattern in case of Roman Numbers every position of a number ie. Thousands, Hundred, Tens, Ones have a unit of multiplication like 1000, 100, 10, 1 respectively. Each has a unit representation like M, C, X and I and also has middle value like D, L and V (except Thousands). They also have following literal to represent their 9th ordinate like IX, XC, CM etc.

Considering this pattern we split the roman number into their individual positions, calculate each position value and progressively add value to the sum.

####ThousandUnitInterpreter
---------------------------
####HundredUnitInterpreter
--------------------------
####TenUnitInterpreter
----------------------
####UnitsUnitInterpreter
------------------------








