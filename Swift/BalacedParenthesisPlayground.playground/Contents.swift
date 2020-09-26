
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

//https://www.faceprep.in/c/balanced-parenthesis-checker/#:~:text=Use%20a%20temporary%20variable%20say,is%20said%20to%20be%20balanced.
//func balaancedParenthesisWithoutStack(str:String)->Bool{
//
//    func checkChar(c:Character)->Character?{
//        if c == "(" {return ")"}
//        if c == "{" {return "}"}
//        if c == "[" {return "]"}
//        return nil
//    }
//    let strCount = str.count
//
//    if strCount == 0 {return true} //0 item is balanced
//    if strCount == 1 {return false} //1 item has not closing
//
//    //if we have closing for a start, it is not balanced
//    if str.first == ")" || str.first == "}" || str.first == "]" {return false}
//
//    let closing = checkChar(c: str.first!)
//
//    var i = 0
//    var count = 0
//
//    for (i,char) in str.enumerated(){
//        //count all the opening parenthensis
//        if char == str.first{count += 1}
//
//        if char == closing{
//            if count == 0 {break}
//             count -= 1
//        }
//    }
//
//     if i == strCount{return false}
//    if i == 1{return checkChar(c: str + 2, strCount - 2)}
//
//    return checkChar(c: str + 1, i - 1) && checkChar(c: str + i + 1, strCount - i -1)
//}


print(balanceParenthesis(str: "(())")) //true
print(balanceParenthesis(str: "(()))")) //false
