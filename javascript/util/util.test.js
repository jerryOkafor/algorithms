var Queue = require('./Queue')
var Stack = require('./Stack')





// stack.print()

// console.log("Peeking")
// console.log(stack.peek())
// console.log(stack.isEmpty())
// console.log("Length: ", stack.length)

// console.log("Poppin")

// console.log(stack.pop())
// console.log(stack.pop())
// console.log(stack.pop())
// console.log(stack.pop())
// console.log(stack.pop())
// console.log(stack.pop())

describe("Test Stack", () => {
    it("Should Pass for Stack: peek, pop, and push", () => {
        let stack = new Stack()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)
        stack.push(6)

        expect(stack.peek()).toBe(6)

        expect(stack.length).toBe(6)
        expect(stack.isEmpty()).toBeFalsy()

        expect(stack.pop()).toBe(6)
        expect(stack.length).toBe(5)
        expect(stack.isEmpty()).toBeFalsy()

        expect(stack.pop()).toBe(5)
        expect(stack.length).toBe(4)
        expect(stack.isEmpty()).toBeFalsy()

        expect(stack.pop()).toBe(4)
        expect(stack.length).toBe(3)
        expect(stack.isEmpty()).toBeFalsy()

        expect(stack.pop()).toBe(3)
        expect(stack.length).toBe(2)
        expect(stack.isEmpty()).toBeFalsy()

        expect(stack.pop()).toBe(2)
        expect(stack.length).toBe(1)
        expect(stack.isEmpty()).toBeFalsy()

        expect(stack.pop()).toBe(1)
        expect(stack.length).toBe(0)
        expect(stack.isEmpty()).toBeTruthy()
    })
})


describe("Test Queue", () => {
    it("Should pass for Queue: enqueue, dequeue and isEmpty", () => {
        let queue = new Queue()

        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)

        expect(queue.isEmpty()).toBeFalsy()
        expect(queue.dequeue()).toBe(1)
        expect(queue.dequeue()).toBe(2)
        expect(queue.dequeue()).toBe(3)
        expect(queue.dequeue()).toBe(4)
        expect(queue.isEmpty()).toBeTruthy()
    })

})