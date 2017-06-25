
import UIKit

class SearchMainViewController: UIViewController, UIPopoverPresentationControllerDelegate, UITextFieldDelegate, UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout, UITableViewDelegate, UITableViewDataSource{

    var serviceType = 1
    //viewtop
    @IBOutlet weak var vTopSearch: UIView!
    @IBOutlet weak var btnDelivery: UIButton!
    @IBOutlet weak var btnReservation: UIButton!
    @IBOutlet weak var btnPickup: UIButton!
    @IBOutlet weak var btnCatering: UIButton!
    
    @IBOutlet weak var stvDelivery: UIStackView!
    @IBOutlet weak var stvPickup: UIStackView!
    @IBOutlet weak var stvReservation: UIStackView!
    @IBOutlet weak var stvCatering: UIStackView!
    
    
    @IBOutlet weak var cvFoods: UICollectionView!
    @IBOutlet weak var tvFoods: UITableView!
    
    @IBOutlet weak var btnCollectionView: UIButton!
    @IBOutlet weak var btnTableView: UIButton!
    
    @IBOutlet weak var btnSearch: UIButton!
    @IBOutlet weak var btnFliter: UIButton!
    
    @IBOutlet weak var tfSearch: UITextField!
    
    
    
    //ForUpperView
    var topSearchViewOrigin = 0.0
    var searchCollectionViewOrigin = 0.0
    var searchTableViewOrigin = 0.0
    //SelectedRow
    var selectedRow = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()

        navigationController?.navigationBar.tintColor = UIColor.white
        navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName: UIColor.white]

        let swipeDown = UISwipeGestureRecognizer(target: self, action: #selector(self.respondToSwipeGesture))
        swipeDown.direction = UISwipeGestureRecognizerDirection.down
        self.vTopSearch.addGestureRecognizer(swipeDown)
        
        let swipeUp = UISwipeGestureRecognizer(target: self, action: #selector(self.respondToSwipeGesture))
        swipeUp.direction = UISwipeGestureRecognizerDirection.up
        self.vTopSearch.addGestureRecognizer(swipeUp)
        
//        let tap = UITapGestureRecognizer(target: self, action: #selector(dismissKeyboard))
//        view.addGestureRecognizer(tap)
        
        topSearchViewOrigin = Double(self.vTopSearch.frame.origin.y)
        searchCollectionViewOrigin = Double(self.cvFoods.frame.origin.y)
        searchTableViewOrigin = Double(self.tvFoods.frame.origin.y)
        
        cvFoods!.register(UINib(nibName: "TableViewingCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: "delivery-cv-cell")
        
        self.updateView(serviceType: self.serviceType)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    

    
    //MARK: - MyFunc
    func respondToSwipeGesture(gesture: UIGestureRecognizer) {
        if let swipeGesture = gesture as? UISwipeGestureRecognizer {
            switch swipeGesture.direction {

            case UISwipeGestureRecognizerDirection.down:

                let rect1 = CGRect(x: vTopSearch.frame.origin.x, y: CGFloat(topSearchViewOrigin) , width: vTopSearch.frame.size.width, height: vTopSearch.frame.size.height)
                self.vTopSearch.frame = rect1
                
                let rect2 = CGRect(x: cvFoods.frame.origin.x, y: CGFloat(searchCollectionViewOrigin) , width: cvFoods.frame.size.width, height: cvFoods.frame.size.height - self.vTopSearch.frame.height + 40)
                self.cvFoods.frame = rect2
                
                let rect3 = CGRect(x: tvFoods.frame.origin.x, y: CGFloat(searchTableViewOrigin) , width: tvFoods.frame.size.width, height: tvFoods.frame.size.height - self.vTopSearch.frame.height + 40)
                self.tvFoods.frame = rect3

            case UISwipeGestureRecognizerDirection.up:
                
                let originFrame = (self.navigationController?.navigationBar.frame.size.height)! + UIApplication.shared.statusBarFrame.height;
                
                let rect1 = CGRect(x: self.vTopSearch.frame.origin.x, y: -( self.vTopSearch.frame.height - originFrame - 40 ), width: self.vTopSearch.frame.size.width, height: self.vTopSearch.frame.size.height)

                self.vTopSearch.frame = rect1
                
                let rect2 = CGRect(x: self.cvFoods.frame.origin.x, y: CGFloat(topSearchViewOrigin + 40) , width: self.cvFoods.frame.size.width, height: self.cvFoods.frame.size.height + self.vTopSearch.frame.height - 40)
                self.cvFoods.frame = rect2
                
                let rect3 = CGRect(x: self.tvFoods.frame.origin.x, y: CGFloat(topSearchViewOrigin + 40) , width: self.tvFoods.frame.size.width, height: self.tvFoods.frame.size.height + self.vTopSearch.frame.height - 40)
                self.tvFoods.frame = rect3


            default:
                break
            }
        }
    }
    
    func dismissKeyboard() {
        self.tfSearch.isHidden = true
        view.endEditing(true)
    }
    
    func updateView(serviceType:Int) {
        
        self.serviceType = serviceType
        switch serviceType {
        case 1:
            navigationController?.navigationBar.barTintColor = GREEN_COLOR
            
            btnDelivery.setBackgroundImage(UIImage(named: "btndeliverygroupedpress"), for: UIControlState.normal)
            self.btnPickup.setBackgroundImage(UIImage(named: "btnpickupgrouped"), for: UIControlState.normal)
            self.btnReservation.setBackgroundImage(UIImage(named: "btnreservgrouped"), for: UIControlState.normal)
            self.btnCatering.setBackgroundImage(UIImage(named: "btncateringgrouped"), for: UIControlState.normal)
            
            self.stvDelivery.isHidden = false
            self.stvPickup.isHidden = true
            self.stvReservation.isHidden = true
            self.stvCatering.isHidden = true
            
            self.tvFoods.reloadData()
            self.cvFoods.reloadData()
        case 2:
            navigationController?.navigationBar.barTintColor = BLUE_COLOR
            
            btnDelivery.setBackgroundImage(UIImage(named: "btndeliverygrouped"), for: UIControlState.normal)
            self.btnPickup.setBackgroundImage(UIImage(named: "btnpickupgroupedpress"), for: UIControlState.normal)
            self.btnReservation.setBackgroundImage(UIImage(named: "btnreservgrouped"), for: UIControlState.normal)
            self.btnCatering.setBackgroundImage(UIImage(named: "btncateringgrouped"), for: UIControlState.normal)
            
            self.stvDelivery.isHidden = true
            self.stvPickup.isHidden = false
            self.stvReservation.isHidden = true
            self.stvCatering.isHidden = true

            
            self.tvFoods.reloadData()
            self.cvFoods.reloadData()
        case 3:
            navigationController?.navigationBar.barTintColor = RED_COLOR
            
            btnDelivery.setBackgroundImage(UIImage(named: "btndeliverygrouped"), for: UIControlState.normal)
            self.btnPickup.setBackgroundImage(UIImage(named: "btnpickupgrouped"), for: UIControlState.normal)
            self.btnReservation.setBackgroundImage(UIImage(named: "btnreservgroupedpress"), for: UIControlState.normal)
            self.btnCatering.setBackgroundImage(UIImage(named: "btncateringgrouped"), for: UIControlState.normal)
            
            self.stvDelivery.isHidden = true
            self.stvPickup.isHidden = true
            self.stvReservation.isHidden = false
            self.stvCatering.isHidden = true

            
            self.tvFoods.reloadData()
            self.cvFoods.reloadData()
        case 4:
            navigationController?.navigationBar.barTintColor = ORANGE_COLOR
            
            btnDelivery.setBackgroundImage(UIImage(named: "btndeliverygrouped"), for: UIControlState.normal)
            self.btnPickup.setBackgroundImage(UIImage(named: "btnpickupgrouped"), for: UIControlState.normal)
            self.btnReservation.setBackgroundImage(UIImage(named: "btnreservgrouped"), for: UIControlState.normal)
            self.btnCatering.setBackgroundImage(UIImage(named: "btncateringgroupedpress"), for: UIControlState.normal)
            
            self.stvDelivery.isHidden = true
            self.stvPickup.isHidden = true
            self.stvReservation.isHidden = true
            self.stvCatering.isHidden = false

            
            self.tvFoods.reloadData()
            self.cvFoods.reloadData()

        default:
            navigationController?.navigationBar.barTintColor = GREEN_COLOR
            
            btnDelivery.setBackgroundImage(UIImage(named: "btndeliverygroupedpress"), for: UIControlState.normal)
            self.btnPickup.setBackgroundImage(UIImage(named: "btnpickupgrouped"), for: UIControlState.normal)
            self.btnReservation.setBackgroundImage(UIImage(named: "btnreservgrouped"), for: UIControlState.normal)
            self.btnCatering.setBackgroundImage(UIImage(named: "btncateringgrouped"), for: UIControlState.normal)
            
            self.stvDelivery.isHidden = false
            self.stvPickup.isHidden = true
            self.stvReservation.isHidden = true
            self.stvCatering.isHidden = true

            
            self.tvFoods.reloadData()
            self.cvFoods.reloadData()

        }
    }
    //MARK: UITextFieldDelegate
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        self.tfSearch.isHidden = true
        view.endEditing(true)
        return true
    }
    
    
    
    //MARK: UICollectionViewDelegateFlowLayout methods
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat
    {
        return 16;
    }
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat
    {
        return 1;
    }
    
    
    //MARK: UICollectionViewDatasource methods
    func numberOfSectionsInCollectionView(collectionView: UICollectionView) -> Int {
        
        return 1
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int{
        
        return 6
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        if self.serviceType == 1 {
            collectionView.register(UINib(nibName:"DeliveryCollectionViewCell",bundle:nil), forCellWithReuseIdentifier: "DeliveryCollectionViewCell")
            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "DeliveryCollectionViewCell", for: indexPath) as! DeliveryCollectionViewCell
            
            cell.layer.borderWidth = 1.0
            cell.layer.borderColor = UIColor.lightGray.cgColor
            cell.layer.cornerRadius = 8
            
            return cell
        }else if self.serviceType == 2{
            collectionView.register(UINib(nibName:"PickupCollectionViewCell",bundle:nil), forCellWithReuseIdentifier: "PickupCollectionViewCell")
            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "PickupCollectionViewCell", for: indexPath) as! PickupCollectionViewCell
            
            cell.layer.borderWidth = 1.0
            cell.layer.borderColor = UIColor.lightGray.cgColor
            cell.layer.cornerRadius = 8
            
            return cell
        }else if self.serviceType == 3{
            collectionView.register(UINib(nibName:"ReservationCollectionViewCell",bundle:nil), forCellWithReuseIdentifier: "ReservationCollectionViewCell")

            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "ReservationCollectionViewCell", for: indexPath) as! ReservationCollectionViewCell
            
            cell.layer.borderWidth = 1.0
            cell.layer.borderColor = UIColor.lightGray.cgColor
            cell.layer.cornerRadius = 8
            
            return cell
        }else{
            collectionView.register(UINib(nibName:"CateringCollectionViewCell",bundle:nil), forCellWithReuseIdentifier: "CateringCollectionViewCell")
            let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "CateringCollectionViewCell", for: indexPath) as! CateringCollectionViewCell
            
            cell.layer.borderWidth = 1.0
            cell.layer.borderColor = UIColor.lightGray.cgColor
            cell.layer.cornerRadius = 8
            
            return cell
        }

    }
    
    
    //MARK: CollectionViewDelegate
    
    public func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        selectedRow = indexPath.row
        self.performSegue(withIdentifier: "detailrestaurant", sender: self)
    }
    
    //MARK: TableViewDelegate
    public func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath){
        self.performSegue(withIdentifier: "detailrestaurant", sender: self)
    }
    
    //MARK: TableViewDataSource
    
    public func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if self.serviceType == 1 {
            let cellIdentifier = "DeliveryTableViewCell"
            tableView.register(UINib(nibName: "DeliveryTableViewCell", bundle: nil), forCellReuseIdentifier: cellIdentifier)
            let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier) as! DeliveryTableViewCell!
            return cell!
        }else if self.serviceType == 2{
            let cellIdentifier = "PickupTableViewCell"
            tableView.register(UINib(nibName: "PickupTableViewCell", bundle: nil), forCellReuseIdentifier: cellIdentifier)
            let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier) as! PickupTableViewCell!
            return cell!
        }else if self.serviceType == 3{
            let cellIdentifier = "ReservationTableViewCell"
            tableView.register(UINib(nibName: "ReservationTableViewCell", bundle: nil), forCellReuseIdentifier: cellIdentifier)
            let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier) as! ReservationTableViewCell!
            return cell!
        }else{
            let cellIdentifier = "CateringTableViewCell"
            tableView.register(UINib(nibName: "CateringTableViewCell", bundle: nil), forCellReuseIdentifier: cellIdentifier)
            let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier) as! CateringTableViewCell!
            return cell!
        }
    }
    
    //MARK: IBAction
    //viewtop
    @IBAction func onDeliveryBtn(_ sender: Any) {
        self.serviceType = 1
        self.updateView(serviceType: 1)
    }
    @IBAction func onReservation(_ sender: Any) {
        self.serviceType = 3
        self.updateView(serviceType: 3)
    }
    @IBAction func onPickupBtn(_ sender: Any) {
        self.serviceType = 2
        self.updateView(serviceType: 2)
    }
    @IBAction func onCateringBtn(_ sender: Any) {
        self.serviceType = 4
        self.updateView(serviceType: 4)
    }
    
    @IBAction func onCollectionView(_ sender: Any) {
        self.cvFoods.isHidden = false
        self.tvFoods.isHidden = true
        
        btnCollectionView.setBackgroundImage(UIImage(named: "btntable"), for: UIControlState.normal)
        btnTableView.setBackgroundImage(UIImage(named: "btnlistempty"), for: UIControlState.normal)
    }
    
    @IBAction func onTableView(_ sender: Any) {
        self.cvFoods.isHidden = true
        self.tvFoods.isHidden = false
        
        btnCollectionView.setBackgroundImage(UIImage(named: "btntableempty"), for: UIControlState.normal)
        btnTableView.setBackgroundImage(UIImage(named: "btnlist"), for: UIControlState.normal)
    }
    
    @IBAction func onFliter(_ sender: Any) {
        
        let popController = UIStoryboard(name: "Main", bundle: nil).instantiateViewController(withIdentifier: "fliterView")
        
        popController.modalPresentationStyle = UIModalPresentationStyle.popover
        
        popController.popoverPresentationController?.permittedArrowDirections = UIPopoverArrowDirection.up
        popController.popoverPresentationController?.delegate = self
        popController.popoverPresentationController?.sourceView = sender as? UIView
        popController.popoverPresentationController?.sourceRect = (sender as AnyObject).bounds
        popController.preferredContentSize = CGSize(width: 172, height: 226)

        self.present(popController, animated: true, completion: nil)
    }
    
    @IBAction func onSearch(_ sender: Any) {
        self.tfSearch.isHidden = false
    }
    
    
    //MARK: UIPopoverPresentationControllerDelegate
    func adaptivePresentationStyle(for controller: UIPresentationController, traitCollection: UITraitCollection) -> UIModalPresentationStyle {
        return UIModalPresentationStyle.none
    }
    

    // MARK: Navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {

        if (segue.identifier == "detail") {
        }
    }


}
