//
//  User.swift/Users/hshack/Documents/fastER/fastER
//  fastER
//
//  Created by Akshay on 3/26/17.
//  Copyright © 2017 Akshay. All rights reserved.
//

import Foundation
import ObjectMapper

typealias JSON = [String:AnyObject]

class User: Mappable {
    var UserName = ""
    var Password = ""
    var Email = ""
    var FirstName = ""
    var MiddleName = ""
    var LastName = ""
    var Title = ""
    var Address = ""
    
    init(UserName: String, Address: String, Password: String, Email: String, FirstName: String, MiddleName: String, LastName: String, Title: String) {
        self.UserName = UserName
        self.Password = Password
        self.Address = Address
        self.Email = Email
        self.FirstName = FirstName
        self.MiddleName = MiddleName
        self.LastName = LastName
        self.Title = Title
    }
    required init?(map: Map) {
    
    }
    
    
    func mapping(map: Map) {
        UserName <- map["username"]
        Password <- map["password"]
        Email <- map["password"]
        Address <- map["address"]
        Title <- map["title"]
        FirstName <- map["first_name"]
        MiddleName <- map["middle_name"]
        LastName <- map["last_name"]
    }
}
