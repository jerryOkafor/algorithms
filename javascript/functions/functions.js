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

/* 
In Javascript, this is the current execution context of a function.
The language has 4 function invocation types:

1. function invocation: alert('Hello World!')
2. method invocation: console.log('Hello World!')
3. constructor invocation: new RegExp('\\d')
4. indirect invocation: alert.call(undefined, 'Hello World!')

Each invovcation instance defines the context in it's own way and this behaves slightly
different that the developer expects.
Also, stric mode also affects the execution context of JavaScript

Terms:
1. Invocation: Invocation of a funtion is the execution of the code that makes the body of the function e.g
    `parseInt('10')`
2. Context of invocation is the value `this` keyword within the function body.
3. Scope of a function is the set of variables, objects, functions accessible within a function body.
*/

//1. `this` in Function Invocation
function func1(a, b) {
    console.log(this) //=> Global scope or window in js browser
    return a + b
}

console.log(func1(1, 2))

//1.1 Function Invocation in Strict mode
function func2(a, b) {
    'use strict' //This is also active for all other functions declared within this function
    console.log(this) // => undefined
    return a + b
}

console.log(func2(1, 2))

//1.2 Bahvior of this in an Innner function
const numbers2 = {
    numberA: 5,
    numberB: 10,
    sum: function () {
        // 'use strict'
        console.log(this)
        console.log(this === numbers2) // => true

        function calc() {
            //`this` is global|window or undefined in strict mode
            console.log(this)
            console.log(this === numbers2) // =>false
            return this.numberA + this.numberB // => 
        }

        return calc()
    }
}

console.log(numbers2.sum()) // => NAN or TypeError: Cannot read property 'numberA' of undefined in strict mode
/* 
Observe: 
numbers2.sum() is method invocation on object numbers2, hence the context in sum is numbers2
calc() is a funtion invocation while numbers2.sum() is method invocation, thus, `this` is the global|window
or undefined in strict mode.

To fix this problem, calc() must execute with the same conext as sum() to access numberA and numberB
*/

//Solution 1: Manually modify the context of calc()
const numbers3 = {
    numberA: 5,
    numberB: 10,
    sum: function () {
        // 'use strict'
        console.log(this)
        console.log(this === numbers3) // => true

        function calc() {
            //`this` is global|window or undefined in strict mode
            console.log(this)
            console.log(this === numbers3) // =>false
            return this.numberA + this.numberB // => 
        }

        return calc.call(this) // use call and pass this to modify the context
    }
}

console.log(numbers3.sum()) // => 15

//Solution 2: Another better soultion is to use arrow function in es6 environment.
//The arroe funtion binds `this` lexically
const numbers4 = {
    numberA: 5,
    numberB: 10,
    sum: function () {
        // 'use strict'
        console.log(this)
        console.log(this === numbers4) // => true

        const calc = () => {
            //`this` is global|window or undefined in strict mode
            console.log(this)
            console.log(this === numbers4) // =>false
            return this.numberA + this.numberB // => 
        }

        return calc()
    }
}

console.log(numbers3.sum()) // => 15

/* 
Diference : Function invocation and method invocation
Method invocation requires property accessor form to call the function while function invocation does not.
*/
console.log(



)
const words = ['Hello', 'World']
console.log(words.join(' ')) // => 'Hello World' ----> method invocation

const obj = {
    myMethod() {
        'use strict'
        console.log(this)
        console.log(this === obj)
        return new Date().toString()
    }
}

//Here context of myMethod is obj even for stric mode
console.log(obj.myMethod()) // =>  Sun Sep 13 2020 12:57:24 GMT+0100 (West Africa Standard Time) ---> method invocation

//Here context of myMethod is global|window or undefined in strict mode
const func3 = obj.myMethod // => Sun Sep 13 2020 12:58:21 GMT+0100 (West Africa Standard Time) ---> function invocation
console.log(func3())

//2. `this` in method invocaton
const calculator = {
    num: 0,
    increment() {
        // 'use strict'
        console.log(this)
        console.log(this === calculator) //=> true for even strict mode
        this.num += 1
        return this.num
    }
}

console.log(calculator.increment()) // method invocation => 1

//This applies for obejects created by inheritance
const myDog = Object.create({
    sayName() {
        console.log(this)
        console.log(this === myDog) // => true for strict execution too
        return this.name
    }
})

myDog.name = "Bull dog"

//method invocation
console.log(myDog.sayName()) // => Bull dog

//For es6 class syntax, the method invocation context is also the instance itself

class Planet {
    constructor(name) {
        this.name = name
    }

    getName() {
        console.log(this)
        console.log(this === earth) // => true
        return this.name
    }
}

const earth = new Planet('Earth')

//method invocation, the context is earth, the instance itself
console.log(earth.getName())


//What happens when a method is seperated from its object

//Problem:
function Pet(type, legs) {
    'use strict'
    this.type = type
    this.legs = legs
    this.logInfo = function () {
        // console.log(this)
        console.log(this === myCat) // => false
        console.log(`This ${this.type} has ${this.legs} legs`)
    }
}


const myCat = new Pet('Cat', 4)
console.log(myCat.logInfo()) // => This Cat has 4 legs
setTimeout(myCat.logInfo, 1000) // => This undefined has undefined legs, same for strict mode

//the above is equivalent to 
const extractedLoginInfo = myCat.logInfo
setTimeout(extractedLoginInfo, 1000)

//The seperated loginInfo is invoked as a function, `this` is global object or undefined in strict mode

//Solution 1: using bind()
const boundLoginInfo = myCat.logInfo.bind(myCat)
setTimeout(boundLoginInfo, 1000) // => This Cat has 4 legs and context = `myCat`

//Solution 2: Using arrow function to bind `this` lexically.

function Pet2(type, legs) {
    this.type = type
    this.legs = legs
    this.logInfo = () => {
        // console.log(this)
        console.log(this === dog) // => false
        console.log(`This ${this.type} has ${this.legs} legs`)
    }
}

const dog = new Pet2('Dog', 4)
setTimeout(dog.logInfo, 1000) //=> This Dog has 4 legs