//
//  User.swift
//  fastER
//
//  Created by Akshay on 3/26/17.
//  Copyright © 2017 Akshay. All rights reserved.
//

import Foundation
import ObjectMapper

class User: Mappable {
    var UserName = ""
    var Password = ""
    var Email = ""
    var FirstName = ""
    var MiddleName = ""
    var LastName = ""
    var Title = ""
    
    init(UserName: String, Password: String, Email: String, FirstName: String, MiddleName: String, LastName: String, Title: String) {
        self.UserName = UserName
        self.Password = Password
        self.Email = Email
        self.FirstName = FirstName
        self.MiddleName = MiddleName
        self.LastName = LastName
        self.Title = Title
    }
}
