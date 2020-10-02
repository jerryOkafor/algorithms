/*:
 # Balanced Parenthesis
 Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 
 Example:
 Input: exp = “[()]{}{[()()]()}”
 
 Output: Balanced

 Input: exp = “[(])”
 
 Output: Not Balanced
*/

//: [Next](@next)


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
