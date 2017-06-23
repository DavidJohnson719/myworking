
import UIKit

class MainViewController: UIViewController {
    
    
    @IBOutlet weak var imgvMain: UIImageView!
    
    @IBOutlet weak var btnDelivery: UIButton!
    @IBOutlet weak var btnPickup: UIButton!
    @IBOutlet weak var btnReservation: UIButton!
    @IBOutlet weak var btnCatering: UIButton!
    
    //View
    @IBOutlet weak var vtransparent1: UIView!
    @IBOutlet weak var vtransparent2: UIView!
    
    
    //Delivery
    @IBOutlet weak var stVDelivery: UIStackView!
    @IBOutlet weak var btnDeliverySearch: UIButton!
    @IBOutlet weak var btnDeliveryArea: UIButton!
    @IBOutlet weak var btnDeliveryCuisine: UIButton!
    
    //Catering
    @IBOutlet weak var stVCatering: UIStackView!
    @IBOutlet weak var btnCateringDate: UIButton!
    @IBOutlet weak var btnCateringTime: UIButton!
    @IBOutlet weak var btnCateringArea: UIButton!
    @IBOutlet weak var btnCateringCuisine: UIButton!
    
    //Pickup
    @IBOutlet weak var stVPickup: UIStackView!
    @IBOutlet weak var btnPickupArea: UIButton!
    @IBOutlet weak var btnPickupCuisine: UIButton!
    
    //Reservation
    @IBOutlet weak var stVReservation: UIStackView!
    @IBOutlet weak var btnReservDate: UIButton!
    @IBOutlet weak var btnReservTime: UIButton!
    @IBOutlet weak var btnReservPersion: UIButton!
    @IBOutlet weak var btnRerservArea: UIButton!
    @IBOutlet weak var btnReservCuisine: UIButton!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationController?.isNavigationBarHidden = false
        
        let image = UIImage(named: "main-title")
        navigationItem.titleView = UIImageView(image: image)
        
        navigationController?.navigationBar.barTintColor = GREEN_COLOR

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    // MARK: - IBActions
    @IBAction func onMenu(_ sender: Any) {
        
    }
    
    @IBAction func onBtnDelivery(_ sender: Any) {
        updateScreen(no: 1)
        btnDelivery.setBackgroundImage(UIImage(named: "btn-delivery-pressed"), for: UIControlState.normal)
        btnPickup.setBackgroundImage(UIImage(named: "btn-pickup"), for: UIControlState.normal)
        btnReservation.setBackgroundImage(UIImage(named: "btn-reservation"), for: UIControlState.normal)
        btnCatering.setBackgroundImage(UIImage(named: "btn-catering"), for: UIControlState.normal)
        imgvMain.image = UIImage(named: "main-delivery")
        stVDelivery.isHidden = false
        stVCatering.isHidden = true
        stVReservation.isHidden = true
        stVPickup.isHidden = true
        vtransparent1.isHidden = false
        vtransparent2.isHidden = true

    }
    @IBAction func onBtnPickup(_ sender: Any) {
        updateScreen(no: 2)
        btnPickup.setBackgroundImage(UIImage(named: "btn-pickup-pressed"), for: UIControlState.normal)
        btnDelivery.setBackgroundImage(UIImage(named: "btn-delivery"), for: UIControlState.normal)
        btnReservation.setBackgroundImage(UIImage(named: "btn-reservation"), for: UIControlState.normal)
        btnCatering.setBackgroundImage(UIImage(named: "btn-catering"), for: UIControlState.normal)
        imgvMain.image = UIImage(named: "main-pickup")
        stVDelivery.isHidden = true
        stVCatering.isHidden = true
        stVReservation.isHidden = true
        stVPickup.isHidden = false
        vtransparent1.isHidden = false
        vtransparent2.isHidden = true
    }
    @IBAction func onBtnReservation(_ sender: Any) {
        updateScreen(no: 3)
        
        btnReservation.setBackgroundImage(UIImage(named: "btn-reservation-pressed"), for: UIControlState.normal)
        btnDelivery.setBackgroundImage(UIImage(named: "btn-delivery"), for: UIControlState.normal)
        btnPickup.setBackgroundImage(UIImage(named: "btn-pickup"), for: UIControlState.normal)
        btnCatering.setBackgroundImage(UIImage(named: "btn-catering"), for: UIControlState.normal)
        imgvMain.image = UIImage(named: "main-reservation")
        stVDelivery.isHidden = true
        stVCatering.isHidden = true
        stVReservation.isHidden = false
        stVPickup.isHidden = true
        vtransparent1.isHidden = true
        vtransparent2.isHidden = false
    }
    @IBAction func onBtnCatering(_ sender: Any) {
        updateScreen(no: 4)
        btnCatering.setBackgroundImage(UIImage(named: "btn-catering-pressed"), for: UIControlState.normal)
        btnDelivery.setBackgroundImage(UIImage(named: "btn-delivery"), for: UIControlState.normal)
        btnPickup.setBackgroundImage(UIImage(named: "btn-pickup"), for: UIControlState.normal)
        btnReservation.setBackgroundImage(UIImage(named: "btn-reservation"), for: UIControlState.normal)
        imgvMain.image = UIImage(named: "main-catering")
        stVDelivery.isHidden = true
        stVCatering.isHidden = false
        stVReservation.isHidden = true
        stVPickup.isHidden = true
        vtransparent1.isHidden = true
        vtransparent2.isHidden = false
    }
    
    @IBAction func onSearchDelivery(_ sender: Any) {
        search(no: 1)
    }
    @IBAction func onDeliveryChooseArea(_ sender: Any) {
        chooseArea(no: 1)
    }
    @IBAction func onDeliveryChooseCuisine(_ sender: Any) {
        chooseCuisine(no: 1)
    }
    
    
    ////////
    @IBAction func onCateringChooseArea(_ sender: Any) {
        chooseArea(no: 1)
    }
    @IBAction func onCateringChooseCuisine(_ sender: Any) {
        chooseCuisine(no: 1)
    }
    @IBAction func onCateringSearch(_ sender: Any) {
        search(no: 1)
    }
    @IBAction func onCateringDate(_ sender: Any) {
    }
    @IBAction func onCateringTime(_ sender: Any) {
    }

    ////////
    @IBAction func onReservDate(_ sender: Any) {
    }
    @IBAction func onReservTime(_ sender: Any) {
    }
    @IBAction func onReservPerson(_ sender: Any) {
    }
    @IBAction func onReservArea(_ sender: Any) {
        chooseArea(no: 1)
    }
    @IBAction func onReservCuisine(_ sender: Any) {
        chooseCuisine(no: 1)
    }
    @IBAction func onReservSearch(_ sender: Any) {
        search(no: 1)
    }
    
    
    ////////
    @IBAction func onPickupArea(_ sender: Any) {
        chooseArea(no: 1)
    }
    @IBAction func onPickupCuisine(_ sender: Any) {
        chooseCuisine(no: 1)
    }
    @IBAction func onPickupSearch(_ sender: Any) {
        search(no: 1)
    }
    
    
    //MARK: - MyFuncs
    
    func updateScreen(no:Int) {
        if no == 1 {
            navigationController?.navigationBar.barTintColor = GREEN_COLOR
            navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName: UIColor.white]
            
        }else if no == 2{
            navigationController?.navigationBar.barTintColor = BLUE_COLOR
            navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName: UIColor.white]

        }else if no == 3{
            navigationController?.navigationBar.barTintColor = RED_COLOR
            navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName: UIColor.white]

        }else if no == 4 {
            navigationController?.navigationBar.barTintColor = ORANGE_COLOR
            navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName: UIColor.white]

        }
    }
    
    func search(no:Int){
        performSegue(withIdentifier: "search", sender: nil)
    }
    
    func chooseArea(no:Int){
        performSegue(withIdentifier: "area", sender: nil)
    }
    func chooseCuisine(no:Int){
        performSegue(withIdentifier: "cuisine", sender: nil)
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
