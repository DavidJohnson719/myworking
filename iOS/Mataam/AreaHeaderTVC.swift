
import UIKit

protocol AreaHeaderTVCDelegate {
    func didSelectAreaHeaderTVC(Selected: Bool, UserHeader: AreaHeaderTVC)
}

class AreaHeaderTVC: UITableViewHeaderFooterView {

    @IBOutlet weak var btnHeader: UIButton!
    @IBOutlet weak var imgArrow: UIImageView!
    
    var section = -1;
    var isOpen = true
    
    var delegate : AreaHeaderTVCDelegate?
    
    @IBAction func selectedHeaderBtn(_ sender: Any) {
        self.delegate?.didSelectAreaHeaderTVC(Selected: false, UserHeader: self)
    }

}
