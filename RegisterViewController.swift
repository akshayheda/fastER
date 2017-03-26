//
//  RegisterViewController.swift
//  fastER
//
//  Created by Akshay on 3/25/17.
//  Copyright © 2017 Akshay. All rights reserved.
//

import UIKit
import ObjectMapper
class RegisterViewController: UIViewController {

    
    @IBOutlet weak var Username: UITextField!
    @IBOutlet weak var Password: UITextField!
    func displayMyAlertMessage(userMessage:String){
        let myAlert = UIAlertController(title:"Alert", message: userMessage, preferredStyle:UIAlertControllerStyle.alert);
        let okAction = UIAlertAction(title:"Ok", style: UIAlertActionStyle.default, handler: nil);
        myAlert.addAction(okAction);
        
        self.present(myAlert, animated:true, completion:nil);
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        
        // Do any additional setup after loading the view.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    @IBAction func Login(_ sender: Any) {
        let Username = self.Username.text
        let Password = self.Password.text
        
        if(Username!.isEmpty || Password!.isEmpty){
            displayMyAlertMessage(userMessage: "All Fields are Required");
            return;
        }
        var request = URLRequest(url: URL(string: "https://medicaldb.herokuapp.com/auth/login")!);
        request.httpMethod = "POST";
        let loginuser = loginUser(Username: Username!, Password: Password!);
        let json = Mapper().toJSON(loginuser);
        print(json)
        request.httpBody = try? JSONSerialization.data(withJSONObject: json)
        
        let task = URLSession.shared.dataTask(with: request) { data, response, error in
            guard let data = data, error == nil else {
                print("error=\(error)")
                return
            }
            
            if let httpStatus = response as? HTTPURLResponse, httpStatus.statusCode != 200 {
                //Proceed from here
                print(httpStatus)
                return
            }
            
            func displayMyAlertMessage(userMessage:String){
                let myAlert = UIAlertController(title:"Alert", message: userMessage, preferredStyle:UIAlertControllerStyle.alert);
                let okAction = UIAlertAction(title:"Ok", style: UIAlertActionStyle.default, handler: nil);
                myAlert.addAction(okAction);
                
                //self.present(myAlert, animated:true, completion:nil);
                
            }

           let check = String(data: data, encoding: .utf8)
            
            if (check == "password") {
                 displayMyAlertMessage(userMessage: "Invalid Username/Password");
                return;
            }

            else if (check == "username") {
                displayMyAlertMessage(userMessage: "Invalid Username/Password");
                return;
            }
            else if (check == "failure") {
                displayMyAlertMessage(userMessage: "Invalid combo");
                return;
            }
            
            else {
                _ = UIAlertAction(title:"Ok", style:UIAlertActionStyle.default) { action in
                    self.dismiss(animated: true, completion:nil);
                }
                self.performSegue(withIdentifier: "loginApproved", sender: self)
                print("should segue")
            }
            // Check the response string from here
        }
        task.resume()

        

        
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
}
