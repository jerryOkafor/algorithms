//: [Previous](@previous)
/*:
 # Boogle: Amazon, Microsoft and Facebook
 Given a dictionary, a method to do lookup in dictionary and a M x N board where
 every cell has one character. Find all possible words that can be formed by a
 sequence of adjacent characters. Note that we can move to any of 8 adjacent
 characters, but a word should not have multiple instances of same cell.
 [Educative io](https://www.educative.io/page/5641478634209280/5676830073815040)
 
 */
//: [Next](@next)

func findWordsWithRecursion(){
    let m = 3
    let n = 3
    
    let boogle:[[Character]]  = [["r","w","e"],["t","e","d"],["s","a","n"]]
    
    print(boogle.count)

    let englishDictionary = ["seed", "weed","need","ate","tend","rent"]

    //Possible directions to visit = 8, with values indicating additive values reauired to
    //to travel the given direction - East, WEST,SOUTH, NORTH,SOUTHEAST,SOUTHWEST,NORTHWEST,NORHTEAST
    let diresctions = [(0,1),(0,-1),(1,0),(-1,0),(1,1),(1,-1),(-1,-1),(-1,1)]

    //track visited cordinate during every loop
    var visited = [[false,false,false],[false,false,false],[false,false,false]]

    var foundWords:[String] = []

    var word = ""
    let MAX_WORD_COUNT = 9
    
    
    func isvalidMove(cord:(row:Int,col:Int), visited: inout[[Bool]])->Bool{
        return cord.row >= 0 && cord.col >= 0 && cord.row < 3 && cord.col < 3 && !visited[cord.row][cord.col]
    }
    
    func findWords(board:[[Character]],visited: inout [[Bool]], cord:(row:Int,col:Int),word:inout String, words:[String]){
        if words.contains(word) {print(word)}
        
        if board.count == MAX_WORD_COUNT {return}
        
        for (rowDiff,colDiff) in diresctions{
            let newRow = cord.row + rowDiff
            let newCol = cord.col + colDiff
            
            if isvalidMove(cord: (newRow,newCol), visited: &visited) {
                visited[newRow][newCol] = true
                var word = word + String(board[newRow][newCol])
                print(word)
                findWords(board: boogle, visited: &visited, cord: (newRow,newCol),word: &word, words: englishDictionary)
                visited[newRow][newCol] = false
            }
        }

    }
    
    
    for i in 0..<m{
        for j in 0..<n{
            visited[i][j] = true
            findWords(board: boogle, visited: &visited, cord: (0,0), word: &word, words: englishDictionary)
            visited[i][j] = false
        }
    }
}


findWordsWithRecursion()
