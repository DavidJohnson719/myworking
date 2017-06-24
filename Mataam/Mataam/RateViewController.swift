

import UIKit
import Cosmos

class RateViewController: UIViewController {

    @IBOutlet weak var vRate: UIView!
    @IBOutlet weak var cvRate: CosmosView!
    @IBOutlet weak var view1: UIView!
    @IBOutlet weak var view2: UIView!
    @IBOutlet weak var tvRate: UITextView!
    @IBOutlet weak var btnApply: UIButton!
    @IBOutlet weak var btnCancel: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.initUI()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    

    //MARK: - MyFunc
    func initUI() {
        self.vRate.layer.cornerRadius = CGFloat(Corner_radious2)
        self.view1.layer.cornerRadius = CGFloat(Corner_radious2)
        self.view2.layer.cornerRadius = CGFloat(Corner_radious2)
        self.btnApply.layer.cornerRadius = CGFloat(Corner_radious2)
        self.btnCancel.layer.cornerRadius = CGFloat(Corner_radious2)
        self.tvRate.placeholder = "Leave a Review (optional)"
    }
    
    //MARK: - IBAction
    @IBAction func onApply(_ sender: Any) {
        navigationController?.popViewController(animated: true)
        dismiss(animated: true, completion: nil)
    }
    @IBAction func onCancel(_ sender: Any) {
        navigationController?.popViewController(animated: true)
        dismiss(animated: true, completion: nil)
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
