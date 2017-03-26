
//  User.swift/Users/hshack/Documents/fastER/fastER
//  fastER
//
//  Created by Akshay on 3/26/17.
//  Copyright © 2017 Akshay. All rights reserved.
//

import Foundation
import ObjectMapper

typealias json = [String:AnyObject]

class loginUser: Mappable {
    var Username = ""
    var Password = ""
    //login email is username chagne later
    init(Username: String, Password: String) {
        self.Password = Password
        self.Username = Username

    }
    required init?(map: Map) {
        
    }
    
    
    func mapping(map: Map) {
        Password <- map["password"]
        Username <- map["username"]
    }
}
