/* Object for Stack like functonality over Javascript */
//Ref: https://scotch.io/tutorials/demystifying-es6-classes-and-prototypal-inheritance
//https://medium.com/better-programming/implementing-a-stack-in-javascript-73d1aa0483c1
var Stack = function () {
    this.items = []
    this.top = 0;

    Object.defineProperty(this, 'length', {
        get: function () { return this.top }
    })
}

Stack.prototype.push = function (element) {
    this.items[this.top] = element
    this.top = this.top + 1
}

Stack.prototype.peek = function () {
    if (!this.isEmpty()) {
        return this.items[this.top - 1]
    }

    return null
}

Stack.prototype.isEmpty = function () {
    return this.top === 0
}

Stack.prototype.pop = function () {
    if (!this.isEmpty()) {

        this.top = this.top - 1
        return this.items.pop()
    }

    return null
}

Stack.prototype.print = function () {
    if (!this.isEmpty()) {
        let top = this.top - 1

        while (top >= 0) {
            console.log(this.items[top])
            top--
        }
    }
}

module.exports = Stack