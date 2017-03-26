//
//  RegisterViewController.swift
//  fastER
//
//  Created by Akshay on 3/25/17.
//  Copyright © 2017 Akshay. All rights reserved.
//

import UIKit

class RegisterViewController: UIViewController {

    @IBOutlet weak var Email: UITextField!
    @IBOutlet weak var Password: UITextField!
    
    func displayMyAlertMessage(userMessage:String){
        var myAlert = UIAlertController(title:"Alert", message: userMessage, preferredStyle:UIAlertControllerStyle.alert);
        let okAction = UIAlertAction(title:"Ok", style: UIAlertActionStyle.default, handler: nil);
        myAlert.addAction(okAction);
        
        self.present(myAlert, animated:true, completion:nil);
    }
    @IBAction func Login(_ sender: Any) {
        let Email = self.Email.text
        let Password = self.Password.text
        
        if(Email!.isEmpty || Password!.isEmpty){
            displayMyAlertMessage(userMessage: "All Fields are Required");
            return;
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()

        
        
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
