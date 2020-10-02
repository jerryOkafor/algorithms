import Foundation

//Simple implementation of Stack in swift
public class Stack<Element> {
    
    public init(){}
    
    private var array : [Element] = []
    
    public func push(_ element: Element) {
        array.append(element)
    }
    
    public func pop() -> Element? {
        let value = array.popLast()
        return value
    }
    
    public func peek() -> Element? {
        return array.last
    }
    
    public func isEmpty() -> Bool {
        return array.isEmpty
    }
}
