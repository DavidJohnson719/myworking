
import UIKit

class DeliveryCheckoutVC: UIViewController {

    @IBOutlet weak var scvContainer: UIScrollView!
    //view0
    @IBOutlet weak var btnRedeemCoupon: UIButton!
    @IBOutlet weak var btnLoyaltyPoints: UIButton!
    @IBOutlet weak var btnMataamPoints: UIButton!
    
    @IBOutlet weak var tfInsertCouponCode: UITextField!
    @IBOutlet weak var btnApplyCoupon: UIButton!
    
    @IBOutlet weak var vLoyaltyPoints: UIView!
    @IBOutlet weak var lblGainedUsed: UILabel!
    @IBOutlet weak var lblBalance: UILabel!
    
    @IBOutlet weak var vMataamPoints: UIView!
    @IBOutlet weak var lblGainedMataam: UILabel!
    @IBOutlet weak var lblMataamBalance: UILabel!
    
    //view1
    @IBOutlet weak var btnAddress: UIButton!
    @IBOutlet weak var vAddress: UIView!
    
    //view2
    @IBOutlet weak var btnNow: UIButton!
    @IBOutlet weak var btnPreorder: UIButton!
    @IBOutlet weak var btnDate: UIButton!
    @IBOutlet weak var btnTime: UIButton!
    
    //view3
    @IBOutlet weak var txtvNote: UITextView!
    
    //view4
    @IBOutlet weak var btnPlaceOrder: UIButton!
    @IBOutlet weak var lblSubtotal: UILabel!
    @IBOutlet weak var lblDeliveryFee: UILabel!
    @IBOutlet weak var lblTotalAmount: UILabel!
    @IBOutlet weak var btnCashondelivery: UIButton!
    @IBOutlet weak var btnCreditCard: UIButton!
    @IBOutlet weak var btnKnet: UIButton!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.initUI()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    //MARK: - MyFunc
    
    func initUI(){
        
        //view0
        btnApplyCoupon.layer.cornerRadius = CGFloat(Corner_radious2)
        
        self.vLoyaltyPoints.layer.cornerRadius = CGFloat(Corner_radious2)
        self.vLoyaltyPoints.layer.borderColor = ORANGE_COLOR.cgColor
        self.vLoyaltyPoints.layer.borderWidth = 1
        
        self.vMataamPoints.layer.cornerRadius = CGFloat(Corner_radious2)
        self.vMataamPoints.layer.borderColor = ORANGE_COLOR.cgColor
        self.vMataamPoints.layer.borderWidth = 1
        
        //view1
        vAddress.layer.cornerRadius = CGFloat(Corner_radious2)
        
        //view2
        btnDate.layer.cornerRadius = CGFloat(Corner_radious2)
        btnTime.layer.cornerRadius = CGFloat(Corner_radious2)
        
        //view3
        txtvNote.layer.cornerRadius = CGFloat(Corner_radious2)
        txtvNote.placeholder = "eg. if you have a food allergy or a request for driver."
        //view4
        btnPlaceOrder.layer.cornerRadius = CGFloat(Corner_radious2)
    }
    
    //MARK: - IBAction
    
    @IBAction func onBackBtn(_ sender: Any) {
        navigationController?.popViewController(animated: true)
        dismiss(animated: true, completion: nil)
    }
    //view0
    
    //view1
    @IBAction func onAddressBtn(_ sender: Any) {
    }
    
    //view2
    @IBAction func onNowBtn(_ sender: Any) {
    }
    @IBAction func onPreorderBtn(_ sender: Any) {
    }
    @IBOutlet weak var onDateBtn: UIButton!
    @IBOutlet weak var onTimeBtn: UIButton!
    
    //view3
    
    //view4
    @IBAction func onBtnCashonDelivery(_ sender: Any) {
    }
    @IBAction func onBtnCreditCard(_ sender: Any) {
    }
    @IBAction func onBtnKnet(_ sender: Any) {
    }
    
    @IBAction func onPlaceOrder(_ sender: Any) {
    }

}
