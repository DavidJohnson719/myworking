import UIKit

class RestaurantDetailVC: UIViewController, UITableViewDataSource, UITableViewDelegate, AreaHeaderTVCDelegate, PressPlusButton {

    @IBOutlet weak var segMenu: UISegmentedControl!
    @IBOutlet weak var tvMenu: UITableView!
    @IBOutlet weak var vReviews: UIView!
    @IBOutlet weak var vInfo: UIView!
    
    //FooterView
    @IBOutlet weak var vFooter: UIView!
    @IBOutlet weak var lblAddedAmount: UILabel!
    @IBOutlet weak var btnViewCart: UIButton!
    @IBOutlet weak var lblTotalAmount: UILabel!
    //Reviews
    @IBOutlet weak var tvReviews: UITableView!
    @IBOutlet weak var lblReviews: UILabel!
    @IBOutlet weak var stvReviews: UIView!
    
    var selectedSection = 1;
    var isHeaderOpen = true
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.initVC()
        self.tvMenu.register(UINib(nibName: "AreaHeaderTVC", bundle: nil), forHeaderFooterViewReuseIdentifier: "areaheader")
        self.stvReviews.layer.borderColor = UIColor.lightGray.cgColor
        self.stvReviews.layer.borderWidth = 1
        self.stvReviews.layer.cornerRadius = 6
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    //MARK: - MyFunc
    func initVC() {
        self.updateViewFromSegIndex (index: 0)
    }
    
    func updateViewFromSegIndex (index: Int) {
        switch  index{
        case 0:
            tvMenu.isHidden = false
            vReviews.isHidden = true
            vInfo.isHidden = true
            vFooter.isHidden = false
        case 1:
            tvMenu.isHidden = true
            vReviews.isHidden = false
            vInfo.isHidden = true
            vFooter.isHidden = true
        case 2:
            tvMenu.isHidden = true
            vReviews.isHidden = true
            vInfo.isHidden = false
            vFooter.isHidden = true
        default:
            break;
        }
    }

    //MARK: - TableViewDataSource

    public func numberOfSections(in tableView: UITableView) -> Int {
        if tableView == self.tvMenu {
            return 2
        }else {
            return 1
        }
    }
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        if tableView == self.tvMenu {
            switch section {
            case 0:
                if section == selectedSection && isHeaderOpen{
                    return 3
                }
            case 1:
                if section == selectedSection && isHeaderOpen{
                    return 2
                }
            default:
                return 0
            }
            return 0
        }else {
            return 6
        }
    }
    
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if tableView == self.tvMenu {
            let cellIdentifier = "DeliveryRestMenuTVC"
            tableView.register(UINib(nibName: "DeliveryRestaurantMenuTVC", bundle: nil), forCellReuseIdentifier: cellIdentifier)
            let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier) as! DeliveryRestaurantMenuTVC!
            cell?.delegate = self
            return cell!

        }else {
            let cellIdentifier = "RestaurantReviewTVC"
            tableView.register(UINib(nibName: "RestaurantReviewTVC", bundle: nil), forCellReuseIdentifier: cellIdentifier)
            let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier) as! RestaurantReviewTVC!
            cell?.vContainer.layer.borderWidth = 1
            cell?.vContainer.layer.borderColor = UIColor.lightGray.cgColor
            cell?.vContainer.layer.cornerRadius = 6
            return cell!
        }
    }

    
    //MARK: - TableViewDelegate
    // Header
    
    public func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        if tableView == self.tvMenu {
            let header = tableView.dequeueReusableHeaderFooterView(withIdentifier: "areaheader") as! AreaHeaderTVC
            header.section = section
            
            if header.section == selectedSection {
                if header.isOpen {
                    header.btnHeader.backgroundColor = UIColor.lightGray
                    header.imgArrow.image = #imageLiteral(resourceName: "arrowdown")
                }else{
                    header.btnHeader.backgroundColor = GREEN_COLOR
                    header.imgArrow.image = #imageLiteral(resourceName: "Arrowup")
                }
            }else {
                header.btnHeader.backgroundColor = UIColor.lightGray
                header.imgArrow.image = #imageLiteral(resourceName: "arrowdown")
            }
            header.btnHeader.titleLabel?.text = "Ahumadi"
            header.delegate = self
            header.btnHeader.layer.cornerRadius = 4
            return header
        }else{
            return nil
        }
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        if tableView == tvMenu {
            return 32.0
        }else{
            return 0
        }
    }
    
    func tableView(_ tableView: UITableView, heightForFooterInSection section: Int) -> CGFloat {
        
        if tableView == tvMenu {
            return 4
        }else{
            return 4
        }

    }
    
    public func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath){
        
    }

    //MARK: - AreaHeaderTVCDelegate
    
    func didSelectAreaHeaderTVC(Selected: Bool, UserHeader: AreaHeaderTVC) {
        selectedSection = UserHeader.section
        isHeaderOpen = !isHeaderOpen
        UserHeader.isOpen = !UserHeader.isOpen
        
        self.tvMenu.reloadData()
    }
    
    //MARK: - PressPlusButtonDelegate
    
    func onPlusButton() {
        self.performSegue(withIdentifier: "addtocart", sender: self)
    }
    
    //MARK: - IBAction
    @IBAction func onBackBtn(_ sender: Any) {
        navigationController?.popViewController(animated: true)
        dismiss(animated: true, completion: nil)
    }
    
    @IBAction func onAddToCartBtn(_ sender: Any) {
        self.performSegue(withIdentifier: "order", sender: self)
    }
    @IBAction func onMenu(_ sender: Any) {
        self.updateViewFromSegIndex(index: segMenu.selectedSegmentIndex)
    }

    @IBAction func onViewCartBtn(_ sender: Any) {
        self.performSegue(withIdentifier: "order", sender: self)
    }
    @IBAction func onAddReview(_ sender: Any) {
    }
    
    
    // MARK: - Navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
    }


}
