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

/* +++++++++++++++++++++++++++++++ */
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

/* ++++++++++++++++++++++++++++ */
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
        console.log('\n\n')
        console.log('Using setTimeout()')
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


/* +++++++++++++++++++++++ */
//3.Constructor Invocation;
/*
Constructor invocation is performed when new keyword is followed by an expression that evaluates to a function object,
an open parenthesis `(`, a comma seperated lsit of expresions and a closing parahtesis `)`

`this` is the newly created object in a constructor invocation.
*/

//pre es6
function Foo() {
    //this is foo instance
    this.property = "Default Value"
}

//constructor invocation
const fooInstance = new Foo();
console.log("\n\n\n")
console.log("Constructor Invocation")
console.log(fooInstance.property) // => 'Default Value'

//es6
class Bar {
    constructor() {
        this.property = "Default Value"
    }
}

const bar = new Bar();
console.log(bar.property) // => 'Default Value'

//3.1 Pitfall :  Forgetin about the `new` keyword.
/* 
Observe tha the instance of the function can be created with or without the new keyword,
however, the two have different beahvior.
*/

const reg1 = new RegExp('\\w+')
const reg2 = RegExp('\\w+')

console.log(reg1 instanceof RegExp) // => true
console.log(reg2 instanceof RegExp) // => true
console.log(reg1.source === reg2.source) // => true

/*
When executing new RegX('\\w+') and RegX('\\w+'), JavaScript creates equivalent regualar expression objects.

Using function invocation to create objects is a potential problem (excluding factory pattern), because some constructors
may ommit the logic to init the object when `new` keaword is missing.

See below:
*/

//here, function Vehicle sets the type and wheelCount on the context of execution which 
//could be different for when `new` keyword is used or not
function Vehicle(type, wheelsCount) {
    console.log('this: ', this)
    this.type = type
    this.wheelsCount = wheelsCount
    return this

}


//consider first invocation : function invocation
const car = Vehicle('Car', 4)
console.log(car.type) // => 'Car'
console.log(car.wheelsCount) // => 4
console.log(car === global) // => true
console.log(global.type) // => 'Car'
console.log(global.wheelsCount) // => 4

//consider second invocation : constructor invocation
const car2 = new Vehicle("Sedan", 4)
console.log(car2.type) // => 'Sedan'
console.log(car2.wheelsCount) // => 4
console.log(car2 === global) // => false
console.log(car2 === car2) // => this

//We enforce the use of new obeject in cases when a constructor call is expected:

function MyVehcle(type, wheelsCount) {
    if (!(this instanceof MyVehcle)) {
        throw Error('Error: Incorrect invocation')
    }

    this.type = type
    this.wheelsCount = wheelsCount
    return this
}

//constructor invocation
const car3 = new MyVehcle('Car', 4)
console.log('\n\n')
console.log(car3.type) // => 'Car'
console.log(car3.wheelsCount) // => 4
console.log(car3 === global) // => false
console.log(car3 === car3) // => this
console.log(car3 instanceof Vehicle) // => true

//function invocation
//const car4 = MyVehcle('Sedan', 4) // => Error: Error: Incorrect invocation


/* +++++++++++++++++++++++++++ */
//4. Indirect Invocation
/*
Indirect invoccation is performed when a function is called using myFun.call() or myFun.appl() methods.
Function in JavaScript are first-class object, which means that a function is an object. The type of this is
`Function`

`.apply()` accepts the first `thisArgs` as the context of the invocation and set of arguments
`.call()` accepts the first `thisArgs` as the context of the invocation and list of/array-like arguments 
Indirect invocation is useful when a function should be executed with a specific context.
*/

function increment(number) {
    return ++number
}

console.log(increment.call(undefined, 10)) // => 11 - set of arguments
console.log(increment.call(undefined, [10])) // => 11 - list of /array-like argumens passed to the function

const rabbit = { name: 'White Rabbit' }

function concatName(string) {
    console.log(this === rabbit) // => true
    return string + " " + this.name
}

//indirect invocations of concatName in rabbit context
console.log(concatName.call(rabbit, 'Hello')) // => 'Hello White Rabbit'
console.log(concatName.apply(rabbit, ['Bye'])) // => 'Bye White Rabbit'

//Another practical example is creating hierarchies of classes in es6 to call the parent constructor
function Runner(name) {
    console.log(this instanceof Rabbit) // => true
    this.name = name
}

function Rabbit(name, countLegs) {
    console.log(this instanceof Rabbit) // => true

    //indirect invocation. call parent constructor
    Runner.call(this, name)
    this.countLegs = countLegs;
}

const myRabbit = new Rabbit('White Rabbit', 4)
console.log(myRabbit) // => Rabbit { name: 'White Rabbit', countLegs: 4 }

/* +++++++++++++++++++++++++ */
//4.1 Bonus: Bound function:
/*
A bind function is a function whose arguments and context is bound to a specific value.
You create a bound function using the .bind() method. The original and bound function
share the same code and scope, but different context on execution

`.bind()` accepts the first `thisArgs` as the context of invocation and a list of 
arguments to be passed to the function.
*/

//`this` in a bound function
const numbers = {

    array: [3, 5, 10],

    getNumbers() {
        //'use strict'
        return this.array
    }
}

//crate a bound funtion
const boundGetNumbers = numbers.getNumbers.bind(numbers) //executes in numbers context
console.log(boundGetNumbers()) // => [ 3, 5, 10 ]

//extract method from object without binding:
const simpleGetNumbers = numbers.getNumbers //executes in global|window context or undefined in strict mode
console.log(simpleGetNumbers()) // => undefined or throw an error in strict mode



/* +++++++++++++++++++++++++ */
//4.2 Tight Context binding
/*
`.bind()` makes a permanent context link and will always keep it. A bound function can not
change it's linked context when using  `.call()` or `.apply()` to a different context. Even a rebound does
doesn't have any effect.
*/

//Prove
function getThis() {
    'use strict'
    return this
}

const one = getThis.bind(1)

console.log(one()) // => 1
console.log(one.call(2)) // changing `thisArgs` to 2 does not have any effecr => 1
console.log(one.apply(2)) // changing `thisArgs` to 2 does not have any effecr => 1
console.log(one.bind(2)) // changing `thisArgs` to 2 does not have any effecr => 1
console.log(new one()) // => getThis {}

//Observe : only new one() changes the context of the bound function. Other types of invocation
//always have this = 1

//4.3  `this in arrow function`
/* 
An arrow function is anonymous. This way it doesn’t have a lexical function name 
(which would be useful for recursion, detaching event handlers).

Also it doesn’t provide the arguments object, opposed to a regular function. 
The missing arguments is fixed using ES2015 rest parameters:

No matter how the arrow function get() is called, it always keeps the lexical context 
numbers. Indirect call with other context get.call([0]) or . get.apply([0]), 
rebinding get.bind([0])() have no effect.

An arrow function cannot be used as a constructor. Invoking it as a constructor
new get() throws an error: TypeError: get is not a constructor
*/
const sumArguments = (...args) => {
    console.log(typeof arguments) // => undefined in browser not Node

    return args.reduce((result, item) => result + item)
}

console.log('\n\n')
console.log(sumArguments.name) // => sumArguments
console.log(sumArguments(5, 4, 6)) // => 15

console.log('\n\n')
class Point {
    constructor(x, y) {
        this.x = x
        this.y = y
    }

    log = () => {
        console.log(this === myPoint) // => true
        setTimeout(() => {
            console.log(this === myPoint) // => true
            console.log(this.x + " : " + this.y) // => 90 : 56
        }, 1000)
    }
}

const myPoint = new Point(90, 56)
myPoint.log()

//Pitfalls: Defining method with an arrow function