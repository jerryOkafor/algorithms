import Foundation

public func measure(title:String, operation:()->()){
    let startTime = CFAbsoluteTimeGetCurrent()
    operation()
    let timeElapsed = CFAbsoluteTimeGetCurrent() - startTime
    print("Time elapsed for \(title) : \(timeElapsed) s.")
}
