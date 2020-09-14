//https://dmitripavlutin.com/6-ways-to-declare-javascript-functions/
/* 
Six ways to decalre JavaScript fundtions:
*/


/*
1. 
A function declaration : made up of a fucntion keyward , followed by an  obligatory function name,
list f parameters in a pair of pareanthesis and a pair of curly braces that delimits the function body.

Note: the function variable is hoisted up to the top of the current scope, which means that the function
cane be invoked before the declaration.
*/
function isEven(num) {
    return num % 2 == 0
}


/* 
1.1
Function decallration can be Regular - you declare the function once and later invoke it in many different places.
An important property of the function decalration is its hoisting mechanism. It allows using the funtion before
the decalration in the same scope
*/

function sum(a, b) {
    return a + b
}

/* 
1.2
Function decalration starts with fuction keyword while function decalration does not:
*/

//It can start with "const", "let" or "var"
const isStruthy = function (value) {
    return !!value
}

//it can be a direct argument for a filter
const numbers = ([1, false, 4,]).filter(function (item) {
    return typeof item === 'number'
});

/* 
It cna be an IIFE (Immediately nnvokded function expression) - a Javascript function that runs as
soon as it is decalred
Ref : https://developer.mozilla.org/en-US/docs/Glossary/IIFE#:~:text=An%20IIFE%20(Immediately%20Invoked%20Function,soon%20as%20it%20is%20defined.
 */
(function messageFunction(message) {
    return message + 'World'
})('Hello');

/*
1.3
Function decalration in conditionals.
*/

//This code is not allowed in strict mode:
(function () {
    //'use strict' //uncoment this to test
    if (true) {
        function ok() {
            return 'true, ok';
        }
    } else {
        function ok() {
            return 'false ok';
        }
    }

    console.log(typeof ok === 'undefined'); //=> true
    console.log(ok()); //Throws "ReferenceError: ok is not defined"
})();

/* 
Note:
When calling ok in the above function, Javascript throws ReferenceError: ok is not definedbecause the 
function decalration is inside a conditional block/

Function decalration in conditionals is allowed in  non static mode, which makes it even more confusing.

As a general rule for these situations, when a function shoule be created by conditionals - use a function expression.
*/


(function () {
    'use strict'
    let ok;
    if (true) {
        ok = function () {
            return 'true, ok';
        }
    } else {
        ok = function () {
            return 'false ok';
        }
    }

    console.log(typeof ok === 'undefined'); //=> true
    console.log(ok()); //Throws "ReferenceError: ok is not defined"
})();


/* 
2.0
Function expression : is determined by a funtions keyword, followed by an optional funtion name, a list of 
parameters in a pair of parenthesis and a pair of curly braces the delimits the body code.

Function expression is the working horse of JavaScript!!
*/

const count = function c(array) {//Function expression. function name 'c' can be optional
    return array.length
}

const methods = {
    numbers: [1, 3, 5, 7],
    sum: function () {
        return this.numbers.reduce(function (acc, num) {
            return acc + num
        })
    }
}


console.log(count([1, 2, 3, 4, 5])) //=> 5
console.log(methods.sum()) // => 16

/*
2.1
Named function expression. An expression function becomes anonymouse when  it does not have a name.
*/

console.log((function (variable) { return typeof variable }).name) // => '' : empty string

//Sometimes the funtion name can be infered when the anonymous function is assinged to a variable
const myFuncVar = function (variable) {
    return typeof variable
}

console.log(myFuncVar.name) //=> myFuncVar

/* 
When the expression has the name specified, this is called named function expression. It is the following property 
compared to simple function expression.
1. When a named function is created, the `name` property of the function holds the name.
2 Inside the function body, a variable with the same name holds the function object.
*/

const getType = function funName(variable) {
    console.log(typeof funName === 'function') // => true
    return typeof variable
}

console.log(getType(3)) // => 'number'
console.log(getType.name) // =>funName
console.log(typeof funName) // =>undefined


/*
It is reasonable to favor named functions and avoid anonymous ones to gain benefits like:

1. The error messages and call stacks show more detailed information when using the function names
2. More comfortable debugging by reducing the number of anonymous stack names
3. The function name says what the function does
4. You can access the function inside its scope for recursive calls or detaching event listeners */

/*
3.0
Shorthand method definition : This can be used on object literals and ES2015 classes
You can define them using a function name, followed by a list of parameters in a pair
of parenthesis (para1, ..., paramN) and a pair of curly braces { ... }
that delimits the body statements.

Benefits:
1. A shorter syntax is easier to understand
2. Shorthand method definition creates a named function, contrary to a function expression. It is useful for debugging.
*/

//in object literal
const collection = {
    items: [],
    add(...items) {
        this.items.push(...items)
    },
    get(index) {
        return this.items[index]
    }
};

collection.add('C', 'C++', 'Java')
console.log(collection.get(1))

//in ES2015 classess | ES6 classes

class Star {
    constructor(name) {
        this.name = name
    }

    getMessage(message) {
        return this.name + message
    }
}

let star = new Star('Sun')
console.log(star.getMessage(' is shining'))

/*
3.1
Computed property names and methods:
ES6 added a nice property fo computed poperty names in object literal and methods

The computed properties use a slight different syntax [methodName]() {...}
*/

const addMethod = 'add'
const getMethod = 'get'

const collection2 = {
    items: [],
    [addMethod](...items) {
        this.items.push(...items)
    },
    [getMethod](index) {
        return this.items[index]
    }
}

collection2.add('C++', 'JAVA', 'PHP')
console.log(collection2.get(2)) // => PHP

//This feature which allows the names of object properties in JavaScript object 
//literal notation to be determined dynamically, i.e. computed

//You can use expressions directly as a computed property name
const fieldNuber = 3
const myObject = {
    field1: 5,
    field3: 10,
    ['field' + fieldNuber]: 10
}

console.log(myObject.field3) // => 10

//You can also use template literals
const fieldNumber1 = 3

const myObject2 = {
    field1: 5,
    field2: 10,
    [`field${fieldNumber1}`]: 15
}

console.log(myObject2.field3) // => 15

/* +++++++++++++++++++++++++++++++++++++++++++ */
/* 
4.0
Arrow functions:
An arrow function is defined using a pair of parenthesis that contains the list
of paramters (param1 ... paramN) followed by a fat arrow "=>" and a pair of curly braces
that delimits the body statment.
*/

const abs = (num) => {
    console.log(typeof abs === 'function') // => true
    if (num < 0) {
        return -num
    }

    return num
}

console.log(abs(-10)) // => 10
console.log(abs(5)) //=>5
console.log(abs.name) // => abs

/*
Note:
Arrow functions don’t have the local variable arguments as do other functions.
The arguments object is an array-like object that allows developers to dynamically
discover and access a function’s arguments. This is helpful because JavaScript
functions can take an unlimited number of arguments. Arrow functions do not have this object.

Properties of arrow functions:
1. The arrow function does not create its execution context, but takes it lexically
    (contrary to function expression or function declaration, which create own this depending on invocation)
2. The arrow function is anonymous. However, the engine can infer its name from
    the variable holding the function.
3. arguments object is not available in the arrow function (contrary to other declaration types
    that provide arguments object). You are free to use rest parameters (...params), though.
*/

