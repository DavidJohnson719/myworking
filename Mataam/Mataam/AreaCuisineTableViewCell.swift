//
//  AreaCuisineTableViewCell.swift
//  Mataam
//
//  Created by AndreszGolanski on 6/17/17.
//  Copyright © 2017 AndreszGolanski. All rights reserved.
//

import UIKit

class AreaCuisineTableViewCell: UITableViewCell {

    @IBOutlet weak var imgvSelect: UIImageView!
    
    @IBOutlet weak var lblName: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
