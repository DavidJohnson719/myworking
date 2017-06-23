
import UIKit

protocol PressPlusButton {
    func onPlusButton()
}

class DeliveryRestaurantMenuTVC: UITableViewCell {

    var delegate: PressPlusButton?
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    @IBAction func onPlusButton(_ sender: Any) {
        delegate?.onPlusButton()
    }
}
