//
//  SubmitController.swift
//  fastER
//
//  Created by HsHack on 3/26/17.
//  Copyright © 2017 Akshay. All rights reserved.
//

import UIKit

class SubmitController: UIViewController {

    @IBOutlet weak var InjuryDescription: UITextView!
    @IBOutlet weak var PainRating: UITextField!

    
    
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
    @IBAction func Submit(_ sender: Any) {
        let InjuryDescription = self.InjuryDescription.text
        let PainRating = self.PainRating.text
        
        if(InjuryDescription!.isEmpty || PainRating!.isEmpty){
            displayMyAlertMessage(userMessage: "All Fields are Required");
            return;
        }
        else {
            
            var myAlert = UIAlertController(title:"Alert", message:"Submitted!", preferredStyle:UIAlertControllerStyle.alert);
            
            let okAction = UIAlertAction(title:"Ok", style:UIAlertActionStyle.default);
            
            myAlert.addAction(okAction);
            self.present(myAlert, animated:true, completion:nil);
            
        }
    }
    // Take the rank by total time from database and display the corresponding address
    // Take the rank by total time from database and display the corresponding hospital name
    
    // Submit button should send pre-filled data and current data to corresponding hospital

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
