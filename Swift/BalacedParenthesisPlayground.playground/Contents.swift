
//Simple implementation of Stack in swift
class Stack<Element> {
    private var array : [Element] = []
    
    func push(_ element: Element) {
        array.append(element)
    }
    
    func pop() -> Element? {
        let value = array.popLast()
        return value
    }
    
    func peek() -> Element? {
        return array.last
    }
    
    func isEmpty() -> Bool {
        return array.isEmpty
    }
}


func balanceParenthesis(str:String)->Bool{
    let stack = Stack<Character>()
    
    for char in str{
        if char == "(" || char == "{" || char == "["{
            stack.push(char)
        }
        
        if char == ")" || char == "}" || char == "]" {
            
            if stack.isEmpty() {return false}
            
            if let top = stack.pop(), (top == "(" && char != ")")
                || top == "{" && char != "}"
                || (top == "[" && char != "]"){
                return false
            }
        }
    }
    
    return stack.isEmpty()
}


print(balanceParenthesis(str: "(())")) //true
print(balanceParenthesis(str: "(()))")) //false
