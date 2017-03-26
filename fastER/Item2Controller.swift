//
//  Item2Controller.swift
//  fastER
//
//  Created by Akshay on 3/26/17.
//  Copyright © 2017 Akshay. All rights reserved.
//

import UIKit

class Item2Controller: UIViewController {
    @IBOutlet weak var FirstName: UITextField!
    @IBOutlet weak var LastName: UITextField!
    @IBOutlet weak var MiddleName: UITextField!
    @IBOutlet weak var PhoneName: UITextField!
    @IBOutlet weak var Email: UITextField!
    @IBOutlet weak var SocialSecurity: UITextField!
    @IBOutlet weak var DateofBirth: UITextField!
    @IBOutlet weak var Gender: UITextField!
    @IBOutlet weak var Race: UITextField!
    @IBOutlet weak var Address: UITextField!
    @IBOutlet weak var EmergencyContact: UITextField!
    @IBOutlet weak var EmergencyContactNumber: UITextField!
    @IBOutlet weak var KnownConditions: UITextField!
    @IBOutlet weak var Surgeries: UITextField!
    @IBOutlet weak var Insurance: UITextField!

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

    @IBAction func Save(_ sender: Any) {
        let FirstName = self.FirstName.text
        let LastName = self.LastName.text
        let MiddleName = self.MiddleName.text
        let PhoneName = self.PhoneName.text
        let Email = self.Email.text
        let SocialSecurity = self.SocialSecurity.text
        let DateofBirth = self.DateofBirth.text
        let Gender = self.Gender.text
        let Race = self.Race.text
        let Address = self.Address.text
        let EmergencyContact = self.EmergencyContact.text
        let EmergencyContactNumber = self.EmergencyContactNumber.text
        let KnownConditions = self.KnownConditions.text
        let Surgeries = self.Surgeries.text
        let Insurance = self.Insurance.text
        
        if(FirstName!.isEmpty || LastName!.isEmpty || MiddleName!.isEmpty || PhoneName!.isEmpty || Email!.isEmpty || SocialSecurity!.isEmpty || DateofBirth!.isEmpty || Gender!.isEmpty || Race!.isEmpty || Address!.isEmpty || EmergencyContact!.isEmpty || EmergencyContactNumber!.isEmpty || KnownConditions!.isEmpty || Surgeries!.isEmpty || Insurance!.isEmpty) {
            //Display Alert Messages
            displayMyAlertMessage(userMessage: "All Fields are Required");
            return;
        }
        
        else {
                
            var myAlert = UIAlertController(title:"Alert", message:"Saved!", preferredStyle:UIAlertControllerStyle.alert);
            
            let okAction = UIAlertAction(title:"Ok", style:UIAlertActionStyle.default);
            
            myAlert.addAction(okAction);
            self.present(myAlert, animated:true, completion:nil);
            
            }
        
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
