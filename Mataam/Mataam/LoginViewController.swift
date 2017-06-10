//
//  LoginViewController.swift
//  Mataam
//
//  Created by AndreszGolanski on 6/9/17.
//  Copyright © 2017 AndreszGolanski. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var scrvLogin: UIScrollView!
    @IBOutlet weak var btnLoggedIn: UIButton!
    
    var isSelect = false
    
    override func viewDidLoad() {
        super.viewDidLoad()

        let tap = UITapGestureRecognizer(target: self, action: #selector(dismissKeyboard))
        view.addGestureRecognizer(tap)
        
        NotificationCenter.default.addObserver(self, selector: #selector(self.keyboardWillShow), name: NSNotification.Name.UIKeyboardWillShow, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(self.keyboardWillHide), name: NSNotification.Name.UIKeyboardWillHide, object: nil)
        
    }

    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        self.navigationController?.isNavigationBarHidden = true
    }

    override func viewWillDisappear(_ animated: Bool) {
        dismissKeyboard()
    }
    
    //MARK: - CustomFunc
    
    func dismissKeyboard() {
        view.endEditing(true)
    }
    
    func keyboardWillShow(notification: NSNotification) {
        if let keyboardSize = (notification.userInfo?[UIKeyboardFrameBeginUserInfoKey] as? NSValue)?.cgRectValue {
            let contentInsets = UIEdgeInsets(top:0.0, left:0.0, bottom:keyboardSize.height, right:0.0)
            scrvLogin.contentInset = contentInsets
        }
    }
    
    func keyboardWillHide(notification: NSNotification) {
        scrvLogin.contentInset = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
    }

    //MARK: - UITextFieldDelegate
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool // called when 'return' key pressed. return false to ignore.
    {
        dismissKeyboard()
        return true
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */
    
    //MARK: - IBActions
    
    @IBAction func onLoggedIn(_ sender: Any) {
        
        if isSelect {
            btnLoggedIn.setImage(UIImage.init(named:"checkbox.png"), for: UIControlState.normal)
            isSelect = false
        }else{
            btnLoggedIn.setImage(UIImage.init(named:"CheckBtn-Pressed.png"), for: .normal)
            isSelect = true
        }
        
    }
    
    @IBAction func onLogin(_ sender: Any) {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "AdVC") as! AdViewController
//        vc.newsObj = newsObj
        navigationController?.pushViewController(vc, animated: true)
    }

}
