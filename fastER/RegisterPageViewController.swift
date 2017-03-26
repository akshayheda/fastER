//
//  RegisterPageViewController.swift
//  fastER
//
//  Created by Akshay on 3/25/17.
//  Copyright © 2017 Akshay. All rights reserved.
//

import UIKit

class RegisterPageViewController: UIViewController {
    @IBOutlet weak var userFirstName: UITextField!
    @IBOutlet weak var userLastName: UITextField!
    @IBOutlet weak var userEmailAddress: UITextField!

    @IBOutlet weak var userPassword: UITextField!
    @IBOutlet weak var userRepeatPassword: UITextField!
    @IBOutlet weak var userName: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    func displayMyAlertMessage(userMessage:String){
        var myAlert = UIAlertController(title:"Alert", message: userMessage, preferredStyle:UIAlertControllerStyle.alert);
        let okAction = UIAlertAction(title:"Ok", style: UIAlertActionStyle.default, handler: nil);
        myAlert.addAction(okAction);
        
        self.present(myAlert, animated:true, completion:nil);
        
    }

    @IBAction func RegisterButtonPressed(_ sender: UIButton) {
        let userFirstName = self.userFirstName.text
        let userLastName = self.userLastName.text
        let userEmail = self.userEmailAddress.text
        let userPass = self.userPassword.text
        let userPassRepeat = self.userRepeatPassword.text
        let userName = self.userName.text
        
   
        //Check for empty fields
        if(userFirstName!.isEmpty || userLastName!.isEmpty || userEmail!.isEmpty || userPass!.isEmpty || userPassRepeat!.isEmpty) {
            //Display Alert Messages
            displayMyAlertMessage(userMessage: "All Fields are Required");
            return;
        }
        
        if(userPass != userPassRepeat) {
            displayMyAlertMessage(userMessage: "Passwords must Match");
            return;
        }
        //Store Data
        UserDefaults.standard.set(userEmail, forKey:"userEmail");
        UserDefaults.standard.set(userFirstName, forKey:"userFirstName");
        UserDefaults.standard.set(userLastName, forKey:"userLastName");
        UserDefaults.standard.set(userPass, forKey:"userPass");
        UserDefaults.standard.set(userPassRepeat, forKey:"userPassRepeat");
        UserDefaults.standard.synchronize();
        
        var request = URLRequest(url: URL(string: "https://medicaldb.heroku.com")!)
        
        request.httpMethod = "POST"
        
        let json = try? JSONSerialization.data(withJSONObject: User(UserName: userName!, Password: userPass!, Email: userEmail!, FirstName: userFirstName!, MiddleName: "", LastName: userLastName!, Title: "Mr."), options: <#T##JSONSerialization.WritingOptions#>)
     
        //Display alert message with confirmation
        var myAlert = UIAlertController(title:"Alert", message:"Registration is successful. Thank you!", preferredStyle:UIAlertControllerStyle.alert);
        
        let okAction = UIAlertAction(title:"Ok", style:UIAlertActionStyle.default) { action in
            self.dismiss(animated: true, completion:nil);
        }
        
        
        myAlert.addAction(okAction);
        self.present(myAlert, animated:true, completion:nil);
        

        
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
